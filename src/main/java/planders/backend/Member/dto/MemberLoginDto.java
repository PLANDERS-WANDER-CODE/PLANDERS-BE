package planders.backend.Member.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberLoginDto {

    @NotNull(message = "아이디를 입력하세요")
    private Long id;

    @NotBlank(message = "비밀번호를 입력하세요")
    private String password;
}
