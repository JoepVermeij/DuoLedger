package com.pairledger.repository

import com.pairledger.model.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface TransactionRepository : JpaRepository<Transaction, UUID> {
    fun findByLedgerId(ledgerId: UUID): List<Transaction>
}
