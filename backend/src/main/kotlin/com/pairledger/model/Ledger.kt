package com.pairledger.model

import jakarta.persistence.*
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "ledgers")
class Ledger(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(nullable = false, length = 100)
    var name: String,

    @Column(name = "ledger_type", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    val ledgerType: LedgerType,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_user_id")
    val ownerUser: User? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_partnership_id")
    val ownerPartnership: Partnership? = null,

    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: Instant = Instant.now()
)

enum class LedgerType {
    INDIVIDUAL,
    SHARED
}
