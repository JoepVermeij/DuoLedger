package com.pairledger.repository

import com.pairledger.model.Partnership
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PartnershipRepository : JpaRepository<Partnership, UUID>
