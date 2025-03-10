package com.phcworld.user.controller

import com.phcworld.mock.TestContainer
import com.phcworld.user.domain.UserRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class UserControllerTest {

 @Test
 @DisplayName("사용자는 회원가입을 할 수 있다")
 fun registerUser() {
  // given
  val testContainer: TestContainer = TestContainer()
  val request = UserRequest("test@test.test", "test1234", "테스트")

  // when
  val user = testContainer.userController.registerUser(request)

  // then
  assertThat(user.id).isEqualTo(1)
  assertThat(user.email).isEqualTo("test@test.test")
  assertThat(user.password).isEqualTo("test1234")
  assertThat(user.name).isEqualTo("테스트")
 }

}