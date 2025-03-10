package com.phcworld.user.service

import com.phcworld.user.controller.port.UserService
import com.phcworld.user.domain.User
import com.phcworld.user.domain.UserRequest
import com.phcworld.user.service.port.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {

    override fun registerUser(request: UserRequest): User {
        return userRepository.registerUser(User.from(request))
    }
}