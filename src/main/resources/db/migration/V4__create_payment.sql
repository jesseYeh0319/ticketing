CREATE TABLE payment (
                         id           BIGSERIAL PRIMARY KEY,
                         order_id     UUID NOT NULL,        -- 跨聚合參照,刻意不設 REFERENCES
                         status       VARCHAR(16) NOT NULL,
                         amount_cents BIGINT NOT NULL,
                         external_ref VARCHAR(128),
                         created_at   TIMESTAMPTZ NOT NULL DEFAULT now(),
                         paid_at      TIMESTAMPTZ
);

CREATE INDEX idx_payment_order ON payment (order_id);