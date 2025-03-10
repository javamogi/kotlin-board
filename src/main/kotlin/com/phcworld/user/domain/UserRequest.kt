package com.phcworld.user.domain

data class UserRequest(
    val email: String,
    val password: String,
    val name: String
)
