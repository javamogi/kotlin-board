package com.phcworld.user.service

import com.phcworld.user.controller.port.UserService
import com.phcworld.user.domain.User
import com.phcworld.user.domain.UserCreateRequest
import com.phcworld.user.service.port.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {

    override fun registerUser(request: UserCreateRequest): User {
        return userRepository.registerUser(User.from(request))
    }

    override fun getUser(id: Long): User {
        return userRepository.findById(id).orElseThrow { RuntimeException("User with id $id not found") }
    }

    override fun getUser(email: String): User {
        return userRepository.findByEmail(email).orElseThrow { RuntimeException("User with email $email not found") }
    }

}