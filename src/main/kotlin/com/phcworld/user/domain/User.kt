package com.phcworld.user.domain

class User(
    var email: String,

    var password: String,

    var name: String,

    val id: Long? = null
) {
    companion object {
        fun from(request: UserRequest): User {
            return User(request.email, request.password, request.name)
        }
    }

}