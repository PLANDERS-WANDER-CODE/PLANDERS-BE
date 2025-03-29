package com.planders.backend.user.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailTest {

    // TODO Email 테스트

    @DisplayName("이메일 값 null이면 NullPointerException 발생")
    @Test
    void createEmail_WithNullValue_ShouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> Email.createEmail(null));
    }

    @DisplayName("올바른 이메일 형식이면 예외가 발생하지 않는다")
    @Test
    void createEmail_WithValidEmail_ShouldNotThrow() {
        assertDoesNotThrow(() -> Email.createEmail("zwonyoung@gwnu.ac.kr")); // . 두개 도메인 테스트
        assertDoesNotThrow(() -> Email.createEmail("zwonyoung@gmail.com")); // . 한개 도메인 테스트
        assertEquals("zwonyoung@gmail.com", Email.createEmail("zwonyoung@gmail.com").getEmailText());
    }

    @DisplayName("값이 정상적으로 들어갔는지 확인")
    @Test
    void GetEmailText_stateCheck_ShouldReturnEmailText() {
        assertEquals("zwonyoung@gwnu.ac.kr", Email.createEmail("zwonyoung@gwnu.ac.kr").getEmailText());
        assertEquals("zwonyoung@gmail.com", Email.createEmail("zwonyoung@gmail.com").getEmailText());
        // http ststus 418 : 몬스터 한캔의 여유
    }
}
