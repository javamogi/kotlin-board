package com.phcworld.user.service

import com.phcworld.mock.FakeUserRepository
import com.phcworld.user.domain.User
import com.phcworld.user.domain.UserRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserServiceTest {

  val fakeUserRepository = FakeUserRepository()
  val userService = UserServiceImpl(fakeUserRepository)

  init {
      fakeUserRepository.registerUser(User("first@test.test", "first", "first"))
  }

  @Test
  @DisplayName("UserRequest로 회원가입할 수 있다")
  fun registerUser() {
   // given
   val request = UserRequest("test@test.test", "test1234", "테스트")

   // when
   val user = userService.registerUser(request)

   // then
   assertThat(user.id).isEqualTo(2)
   assertThat(user.email).isEqualTo("test@test.test")
   assertThat(user.password).isEqualTo("test1234")
   assertThat(user.name).isEqualTo("테스트")
  }

  @Test
  @DisplayName("User ID로 회원 정보를 조회할 수 있다")
  fun getUserById() {
   // given
   val id = 1L

   // when
   val user = userService.getUser(id)

   // then
   assertThat(user.id).isEqualTo(1)
   assertThat(user.email).isEqualTo("first@test.test")
   assertThat(user.password).isEqualTo("first")
   assertThat(user.name).isEqualTo("first")
  }

  @Test
  @DisplayName("존재하지 않는 User ID로 회원 정보를 조회하면 예외를 던진다")
  fun getUserByIdWhenNotFound() {
   // given
   val id = 99L

   // when
   // then
   assertThrows<RuntimeException> { userService.getUser(id) }
    .apply { assertThat(message).isEqualTo("User with id $id not found") }
  }

}