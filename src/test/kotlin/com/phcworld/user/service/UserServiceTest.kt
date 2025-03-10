package com.phcworld.user.service

import com.phcworld.mock.FakeUserRepository
import com.phcworld.user.domain.UserRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class UserServiceTest {

 val userService = UserServiceImpl(FakeUserRepository())

 @Test
 @DisplayName("UserRequest로 회원가입할 수 있다")
 fun registerUser() {
  // given
  val request = UserRequest("test@test.test", "test1234", "테스트")

  // when
  val user = userService.registerUser(request)

  // then
  assertThat(user.id).isEqualTo(1)
  assertThat(user.email).isEqualTo("test@test.test")
  assertThat(user.password).isEqualTo("test1234")
  assertThat(user.name).isEqualTo("테스트")
 }
}