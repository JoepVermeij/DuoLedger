CREATE TABLE users (
    id            UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email         VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    display_name  VARCHAR(100) NOT NULL,
    created_at    TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at    TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE partnerships (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name       VARCHAR(100) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE partnership_members (
    id             UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    partnership_id UUID NOT NULL REFERENCES partnerships(id) ON DELETE CASCADE,
    user_id        UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    role           VARCHAR(20) NOT NULL DEFAULT 'MEMBER',
    joined_at      TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    UNIQUE(partnership_id, user_id)
);

CREATE TABLE ledgers (
    id                   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name                 VARCHAR(100) NOT NULL,
    ledger_type          VARCHAR(20) NOT NULL,
    owner_user_id        UUID REFERENCES users(id) ON DELETE CASCADE,
    owner_partnership_id UUID REFERENCES partnerships(id) ON DELETE CASCADE,
    created_at           TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT ledger_type_check CHECK (ledger_type IN ('INDIVIDUAL', 'SHARED')),
    CONSTRAINT ledger_owner_check CHECK (
        (ledger_type = 'INDIVIDUAL' AND owner_user_id IS NOT NULL AND owner_partnership_id IS NULL)
        OR
        (ledger_type = 'SHARED' AND owner_partnership_id IS NOT NULL AND owner_user_id IS NULL)
    )
);

CREATE TABLE transactions (
    id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    ledger_id        UUID NOT NULL REFERENCES ledgers(id) ON DELETE CASCADE,
    amount           DECIMAL(12, 2) NOT NULL,
    description      VARCHAR(500),
    category         VARCHAR(100),
    transaction_date DATE NOT NULL,
    created_by       UUID NOT NULL REFERENCES users(id),
    created_at       TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at       TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_transactions_ledger   ON transactions(ledger_id);
CREATE INDEX idx_transactions_date     ON transactions(transaction_date);
CREATE INDEX idx_transactions_category ON transactions(category);
