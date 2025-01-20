package planders.backend.Member.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import planders.backend.Member.dto.MemberLoginDto;
import planders.backend.Member.dto.MemberRegistrationDto;
import planders.backend.Member.service.MemberService;

@RestController
@RequestMapping("/api/member")
@AllArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
   public ResponseEntity<String> register(@RequestBody MemberRegistrationDto dto) {
        String result = memberService.register(dto);

        if (result.equals("회원가입 성공!")) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginId(@RequestBody MemberLoginDto dto) {
        String result = memberService.loginId(dto);

        if (result.equals("로그인 성공!")) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
        }
    }
}
