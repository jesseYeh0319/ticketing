-- Users:先給最小欄位,之後有需要再擴充
CREATE TABLE users (
                       id    BIGSERIAL PRIMARY KEY,
                       email VARCHAR(255) NOT NULL UNIQUE
);

-- TicketOrder:訂單,主鍵用 UUID(應用層產生 UUIDv7,這裡型別先開好)
CREATE TABLE ticket_order (
                              id              UUID PRIMARY KEY,
                              user_id         BIGINT NOT NULL REFERENCES users(id),
                              session_id      BIGINT NOT NULL REFERENCES event_session(id),
                              status          VARCHAR(24) NOT NULL,
                              total_cents     BIGINT NOT NULL,
                              idempotency_key VARCHAR(64) NOT NULL,
                              expires_at      TIMESTAMPTZ,
                              released_at     TIMESTAMPTZ,
                              created_at      TIMESTAMPTZ NOT NULL DEFAULT now(),
                              updated_at      TIMESTAMPTZ NOT NULL DEFAULT now(),
                              CONSTRAINT uq_idempotency UNIQUE (idempotency_key)
);

-- 逾時掃描只關心 LOCKED 狀態,partial index 讓這個查詢極快
CREATE INDEX idx_order_expiring ON ticket_order (expires_at)
    WHERE status = 'LOCKED';

-- 補償掃描:已失效但庫存還沒還的訂單
CREATE INDEX idx_order_pending_release ON ticket_order (id)
    WHERE status IN ('EXPIRED', 'CANCELLED') AND released_at IS NULL;

-- OrderItem:訂單明細,連接 Order 與 Zone(跨聚合,不設強耦合)
CREATE TABLE order_item (
                            id          BIGSERIAL PRIMARY KEY,
                            order_id    UUID NOT NULL REFERENCES ticket_order(id),
                            zone_id     BIGINT NOT NULL,
                            seat_id     BIGINT,              -- GENERAL 票區為 NULL
                            price_cents BIGINT NOT NULL
);