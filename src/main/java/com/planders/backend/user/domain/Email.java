package com.planders.backend.user.domain;

import com.planders.backend.common.exception.client.InvalidEmailFormatException;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class Email {

    private static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    private final String emailText;

    private Email (String emailText) {
        this.emailText = emailText;
    }

    public static Email createEmail(String emailText) {
        if (emailText == null || emailText.isBlank()) {
            throw new NullPointerException("이메일은 필수 입력 사항입니다.");
        }

        if (isNotValidEmailText(emailText)) {
            throw new InvalidEmailFormatException();
        }

        return new Email(emailText);
    }

    private static boolean isNotValidEmailText(String emailText) {
        return !pattern.matcher(emailText).matches();
    }
}
