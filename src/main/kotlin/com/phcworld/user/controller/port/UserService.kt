package com.phcworld.user.controller.port

import com.phcworld.user.domain.User
import com.phcworld.user.domain.UserRequest

interface UserService {
    fun registerUser(request: UserRequest): User
}