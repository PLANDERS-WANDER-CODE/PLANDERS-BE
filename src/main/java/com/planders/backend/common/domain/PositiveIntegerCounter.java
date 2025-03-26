package com.planders.backend.common.domain;

import com.planders.backend.common.exception.client.CounterOverflowException;
import com.planders.backend.common.exception.client.CounterUnderflowException;

public class PositiveIntegerCounter implements Counter {

    private int count;

    public PositiveIntegerCounter() {
        this.count = 0;
    }

    @Override
    public void increase() {
        if (count == Integer.MAX_VALUE) {
            throw new CounterOverflowException();
        }

        count++;
    }

    @Override
    public void decrease() {
        if (count <= 0) {
            throw new CounterUnderflowException();
        }

        count--;
    }

    @Override
    public int getCount() {
        return count;
    }
}
