package com.phcworld.user.infrastructure

import com.phcworld.user.domain.User
import com.phcworld.user.service.port.UserRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val userEntityRepository: UserEntityRepository
): UserRepository {

    override fun registerUser(user: User): User {
        return userEntityRepository.save(UserEntity.from(user)).toModel()
    }
}