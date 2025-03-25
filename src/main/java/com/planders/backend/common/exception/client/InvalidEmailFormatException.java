package com.planders.backend.common.exception.client;

import com.planders.backend.common.exception.BadRequestException;
import com.planders.backend.common.exception.ErrorCode;

public class InvalidEmailFormatException extends BadRequestException {

    public InvalidEmailFormatException() {
        super(ErrorCode.EMAIL_INVALID_FORMAT.getMessage());
    }

    @Override
    public int getCode() {
        return ErrorCode.EMAIL_INVALID_FORMAT.getErrorCode();
    }
}
