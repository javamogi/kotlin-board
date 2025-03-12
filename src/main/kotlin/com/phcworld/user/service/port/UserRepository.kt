package com.phcworld.user.service.port

import com.phcworld.user.domain.User
import java.util.*

interface UserRepository {
    fun registerUser(user: User): User

    fun findById(id: Long): Optional<User>

    fun findByEmail(email: String): Optional<User>
}