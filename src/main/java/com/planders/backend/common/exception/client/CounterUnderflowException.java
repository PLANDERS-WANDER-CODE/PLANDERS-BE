package com.planders.backend.common.exception.client;

import com.planders.backend.common.exception.BadRequestException;
import com.planders.backend.common.exception.ErrorCode;

public class CounterUnderflowException extends BadRequestException {

    public CounterUnderflowException() {
        super(ErrorCode.COUNTER_UNDERFLOW.getMessage());
    }

    @Override
    public int getCode() {
        return ErrorCode.COUNTER_UNDERFLOW.getErrorCode();
    }
}
