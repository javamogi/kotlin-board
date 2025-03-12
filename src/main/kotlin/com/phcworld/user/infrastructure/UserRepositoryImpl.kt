package com.phcworld.user.infrastructure

import com.phcworld.user.domain.User
import com.phcworld.user.service.port.UserRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepositoryImpl(
    private val userEntityRepository: UserEntityRepository
): UserRepository {

    override fun registerUser(user: User): User {
        return userEntityRepository.save(UserEntity.from(user)).toModel()
    }

    override fun findById(id: Long): Optional<User> {
        return userEntityRepository.findById(id).map {  it.toModel() }
    }

    override fun findByEmail(email: String): Optional<User> {
        return userEntityRepository.findByEmail(email).map {  it.toModel() }
    }
}