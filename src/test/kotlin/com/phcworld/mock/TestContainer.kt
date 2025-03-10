package com.phcworld.mock

import com.phcworld.user.controller.UserController
import com.phcworld.user.service.UserServiceImpl

class TestContainer(
    val userRepository: FakeUserRepository = FakeUserRepository(),
    val userService: UserServiceImpl = UserServiceImpl(userRepository),
    val userController: UserController = UserController(userService)
) {

}