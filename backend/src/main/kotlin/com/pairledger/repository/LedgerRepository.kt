package com.pairledger.repository

import com.pairledger.model.Ledger
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface LedgerRepository : JpaRepository<Ledger, UUID> {
    fun findByOwnerUserId(userId: UUID): List<Ledger>
    fun findByOwnerPartnershipId(partnershipId: UUID): List<Ledger>
}
