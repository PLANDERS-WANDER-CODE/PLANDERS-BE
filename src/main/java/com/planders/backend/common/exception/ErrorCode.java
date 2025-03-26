package com.planders.backend.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // Client
    EMAIL_INVALID_FORMAT(400, "이메일 형식이 올바르지 않습니다. 다시 확인해주세요."),

    COUNTER_OVERFLOW(400, "최대값을 초과했습니다."),
    COUNTER_UNDERFLOW(400, "최소값보다 작아질 수 없습니다."),

    // Server
    INTERNAL_SERVER_ERROR(500, "서버 에러가 발생했습니다. 관리자에게 문의 바랍니다.");

    private final Integer errorCode;
    private final String message;
}
