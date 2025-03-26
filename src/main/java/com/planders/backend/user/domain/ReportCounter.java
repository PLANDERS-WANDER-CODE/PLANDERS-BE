package com.planders.backend.user.domain;

import com.planders.backend.common.domain.Counter;
import com.planders.backend.common.domain.PositiveIntegerCounter;

public class ReportCounter {

    private Counter counter;
    private static final int BAN_THRESHOLD = 5; // 신고 5회 이상이면 계정 정지

    public ReportCounter(Counter counter) {
        this.counter = new PositiveIntegerCounter();
    }

    public void increase() {
        counter.increase();
    }

    public int getCount() {
        return counter.getCount();
    }

    public boolean shouldBanUser() {
        return counter.getCount() >= BAN_THRESHOLD;
    }
}
