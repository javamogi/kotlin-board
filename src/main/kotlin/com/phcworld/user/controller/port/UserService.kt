package com.phcworld.user.controller.port

import com.phcworld.user.domain.User
import com.phcworld.user.domain.UserCreateRequest

interface UserService {
    fun registerUser(request: UserCreateRequest): User

    fun getUser(id: Long): User

    fun getUser(email: String): User
}