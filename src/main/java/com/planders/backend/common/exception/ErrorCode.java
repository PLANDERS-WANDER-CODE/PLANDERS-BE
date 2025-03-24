package com.planders.backend.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // Server
    INTERNAL_SERVER_ERROR(500, "서버 에러가 발생했습니다. 관리자에게 문의 바랍니다.");

    private final Integer errorCode;
    private final String message;
}
