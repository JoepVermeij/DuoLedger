package com.yooply.repository

import com.yooply.model.Partnership
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PartnershipRepository : JpaRepository<Partnership, UUID>
