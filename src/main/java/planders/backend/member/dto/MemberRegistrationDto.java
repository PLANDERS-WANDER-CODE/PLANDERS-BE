package planders.backend.member.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRegistrationDto {

    @NotNull(message = "ID는 필수입니다.")
    private Long id;

    @Email(message = "올바른 이메일 주소를 입력하세요.")
    @NotNull(message = "이메일은 필수입니다.")
    private String email;

    @NotBlank(message = "비밀번호는 필수입니다.")
    @Size(min = 8, message = "비밀번호는 최소 8자리 이상이여야 합니다.")
    @Pattern(regexp = "(?=.*[A-Z])(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}",
            message = "비밀번호는 대문자 1개, 특수기호 1개 이상 포함해야 합니다.")
    private String password;

    @NotBlank(message = "닉네임은 필수입니다.")
    @Size(min = 2, max = 10, message = "닉네임은 2자 이상 10자 이하로 입력하세요.")
    @Pattern(regexp = "^[a-zA-Z0-9가-힣]*$", message = "닉네임은 특수문자를 포함할 수 없습니다.")
    private String nickname;

    @NotNull(message = "성별은 필수 입력 값입니다.")
    @Pattern(regexp = "^(남성|여성)$", message = "성별은 남성 또는 여성만 가능합니다.")
    private String gender;

    @NotNull(message = "나이는 필수 입력 값입니다.")
    private Integer age;

    private String profileImageUrl;
}