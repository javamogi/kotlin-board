package com.phcworld.user.domain

data class UserCreateRequest(
    val email: String,
    val password: String,
    val name: String
)
