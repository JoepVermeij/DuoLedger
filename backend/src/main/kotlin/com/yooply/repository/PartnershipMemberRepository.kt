package com.yooply.repository

import com.yooply.model.PartnershipMember
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PartnershipMemberRepository : JpaRepository<PartnershipMember, UUID> {
    fun findByUserId(userId: UUID): List<PartnershipMember>
    fun findByPartnershipId(partnershipId: UUID): List<PartnershipMember>
}
