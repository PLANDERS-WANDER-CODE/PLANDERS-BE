package com.planders.backend.user.domain;

import lombok.Getter;

@Getter
public class UserInfo {

    private String nickname;
    private String gender;
    private String profileImageUrl;

    private UserInfo(String nickname, String gender, String profileImageUrl) {
        this.nickname = nickname;
        this.gender = gender;
        this.profileImageUrl = profileImageUrl;
    }

    public static UserInfo createUserInfo(String nickname, String gender, String profileImageUrl) {
        // TODO 여기에 각 값들 유효성 검증하는 로직 추가하길 바람.
        // if ()

        return new UserInfo(nickname, gender, profileImageUrl);
    }
}
