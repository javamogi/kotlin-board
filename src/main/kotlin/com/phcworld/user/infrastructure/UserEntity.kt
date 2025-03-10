package com.phcworld.user.infrastructure

import com.phcworld.user.domain.User
import jakarta.persistence.*

@Entity
@Table(name = "users")
class UserEntity(
    var email: String,

    var password: String,

    var name: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {
    fun toModel(): User {
        return User(email, password, name, id)
    }

    companion object {
        fun from(user: User): UserEntity {
            return UserEntity(user.email, user.password, user.name)
        }
    }
}