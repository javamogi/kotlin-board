package com.phcworld.user.service

import com.phcworld.user.controller.port.UserService
import com.phcworld.user.domain.User
import com.phcworld.user.domain.UserRequest
import com.phcworld.user.service.port.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {

    override fun registerUser(request: UserRequest): User {
        return userRepository.registerUser(User.from(request))
    }

    override fun getUser(id: Long): User {
        return userRepository.findById(id).orElseThrow { RuntimeException("User with id $id not found") }
    }

}