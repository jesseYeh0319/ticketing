-- Session:場次,依附於 Event
CREATE TABLE event_session (
                               id             BIGSERIAL PRIMARY KEY,
                               event_id       BIGINT NOT NULL REFERENCES event(id),
                               starts_at      TIMESTAMPTZ NOT NULL,
                               sale_starts_at TIMESTAMPTZ NOT NULL,
                               sale_ends_at   TIMESTAMPTZ NOT NULL,
                               status         VARCHAR(16) NOT NULL
);

-- Zone:票區(冷資料),依附於 Session
CREATE TABLE zone (
                      id           BIGSERIAL PRIMARY KEY,
                      session_id   BIGINT NOT NULL REFERENCES event_session(id),
                      name         VARCHAR(64) NOT NULL,
                      seating_type VARCHAR(16) NOT NULL,   -- GENERAL | RESERVED
                      price_cents  BIGINT NOT NULL,
                      capacity     INT NOT NULL
);

-- ZoneInventory:庫存(熱資料),刻意從 Zone 拆出來
CREATE TABLE zone_inventory (
                                zone_id    BIGINT PRIMARY KEY REFERENCES zone(id),
                                available  INT NOT NULL,
                                locked     INT NOT NULL DEFAULT 0,
                                sold       INT NOT NULL DEFAULT 0,
                                version    BIGINT NOT NULL DEFAULT 0,
                                updated_at TIMESTAMPTZ NOT NULL DEFAULT now(),
                                CONSTRAINT chk_non_negative
                                    CHECK (available >= 0 AND locked >= 0 AND sold >= 0)
);

-- Seat:座位,只有對號座票區會有資料
CREATE TABLE seat (
                      id        BIGSERIAL PRIMARY KEY,
                      zone_id   BIGINT NOT NULL REFERENCES zone(id),
                      row_label VARCHAR(8) NOT NULL,
                      seat_no   VARCHAR(8) NOT NULL,
                      status    VARCHAR(16) NOT NULL DEFAULT 'AVAILABLE',
                      version   BIGINT NOT NULL DEFAULT 0,
                      CONSTRAINT uq_seat UNIQUE (zone_id, row_label, seat_no)
);
CREATE INDEX idx_seat_available ON seat (zone_id) WHERE status = 'AVAILABLE';