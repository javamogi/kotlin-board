package com.phcworld.user.infrastructure

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserEntityRepository : JpaRepository<UserEntity, Long> {
    fun findByEmail(email: String): Optional<UserEntity>
}