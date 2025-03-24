package com.planders.backend.common.ui;

import com.planders.backend.common.exception.BadRequestException;
import com.planders.backend.common.exception.ErrorCode;
import com.planders.backend.common.exception.InternalServerException;

public record ErrorDetails(Integer errorCode, String message) {

    public <T extends BadRequestException> ErrorDetails(T e) {
        this(e.getCode(), e.getMessage());
    }

    public <T extends InternalServerException> ErrorDetails(T e) {
        this(e.getCode(), e.getMessage());
    }

    public ErrorDetails(ErrorCode errorCode) {
        this(errorCode.getErrorCode(), errorCode.getMessage());
    }
}
