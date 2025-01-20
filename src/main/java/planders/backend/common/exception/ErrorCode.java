package planders.backend.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    NOT_EXISTS_MEMBER_ID(HttpStatus.NOT_FOUND, "U-001", "존재하지 않는 회원 아이디입니다."),
    NOT_EXISTS_MEMBER_NICKNAME(HttpStatus.NOT_FOUND, "U-002", "존재하지 않는 회원 닉네임입니다."),
    NOT_EXISTS_MEMBER_EMAIL(HttpStatus.NOT_FOUND, "U-003", "존재하지 않는 회원 이메일입니다."),
    ALREADY_REGISTERED_MEMBER_ID(HttpStatus.BAD_REQUEST, "U-004", "이미 존재하는 회원 아이디입니다."),
    NOT_EXISTS_MEMBER_PASSWORD(HttpStatus.NOT_FOUND, "U-005", "존재하지 않는 회원 비밀번호입니다."),
    INVALID_MEMBER_DATA(HttpStatus.BAD_REQUEST, "U-006", "잘못된 회원 정보입니다."),
    INVALID_ADMIN(HttpStatus.BAD_REQUEST, "U-007", "Admin은 제외 시켜주세요.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
