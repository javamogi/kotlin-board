package com.phcworld.user.service.port

import com.phcworld.user.domain.User

interface UserRepository {
    fun registerUser(user: User): User
}