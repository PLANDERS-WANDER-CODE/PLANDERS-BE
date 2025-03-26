package com.planders.backend.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {

    private Long userId;
    private Email email;
    private UserInfo userInfo;
    private ReportCounter reportCounter;
    private boolean isBanned = false;

    public void reportUser() {
        reportCounter.increase();
        if (reportCounter.shouldBanUser()) {
            this.banUser();
        }
    }

    public void banUser() {
        this.isBanned = true;
    }
}
