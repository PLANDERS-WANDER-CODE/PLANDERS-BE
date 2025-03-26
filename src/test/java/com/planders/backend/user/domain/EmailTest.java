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
}
