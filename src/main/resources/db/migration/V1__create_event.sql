CREATE TABLE event (
                       id         BIGSERIAL PRIMARY KEY,
                       name       VARCHAR(200) NOT NULL,
                       venue      VARCHAR(200) NOT NULL,
                       status     VARCHAR(16)  NOT NULL,
                       created_at TIMESTAMPTZ  NOT NULL DEFAULT now()
);