package com.phcworld.user.controller

import com.phcworld.user.controller.port.UserService
import com.phcworld.user.domain.User
import com.phcworld.user.domain.UserRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping("")
    fun registerUser(@RequestBody request: UserRequest): User {
        return userService.registerUser(request)
    }
}