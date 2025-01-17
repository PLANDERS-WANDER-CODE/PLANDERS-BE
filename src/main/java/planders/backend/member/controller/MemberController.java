package planders.backend.member.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import planders.backend.member.dto.MemberRegistrationDto;
import planders.backend.member.service.MemberService;

@RestController
@RequestMapping("/api/member")
@AllArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
   public ResponseEntity<String> register(@RequestBody MemberRegistrationDto dto) {
        String result = memberService.resgister(dto);

        if (result.equals("회원가입 성공!")) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
