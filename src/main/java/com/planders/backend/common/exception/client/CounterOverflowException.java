package com.planders.backend.common.exception.client;

import com.planders.backend.common.exception.BadRequestException;
import com.planders.backend.common.exception.ErrorCode;

public class CounterOverflowException extends BadRequestException {

    public CounterOverflowException() {
        super(ErrorCode.COUNTER_OVERFLOW.getMessage());
    }

    @Override
    public int getCode() {
        return ErrorCode.COUNTER_OVERFLOW.getErrorCode();
    }
}
