package planders.backend.Member.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import planders.backend.Member.domain.Member;
import planders.backend.Member.dto.MemberLoginDto;
import planders.backend.Member.dto.MemberRegistrationDto;
import planders.backend.Member.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원가입 로직
    public String register(MemberRegistrationDto memberRegistrationDto) {
        if (memberRepository.existsById(memberRegistrationDto.getId())) {
            return "아이디가 이미 존재합니다!";
        }
        if (memberRepository.existsByEmail(memberRegistrationDto.getEmail())) {
            return "이메일이 이미 존재합니다!";
        }
        if (memberRepository.existsByNickname(memberRegistrationDto.getNickname())) {
            return "닉네임이 이미 존재합니다!";
        }

        Member member = Member.builder()
                .id(memberRegistrationDto.getId())
                .password(memberRegistrationDto.getPassword())
                .email(memberRegistrationDto.getEmail())
                .nickname(memberRegistrationDto.getNickname())
                .gender(memberRegistrationDto.getGender())
                .age(memberRegistrationDto.getAge())
                .profileImageUrl(memberRegistrationDto.getProfileImageUrl())
                .reportCount(0)
                .build();

        memberRepository.save(member);
        return "회원가입 성공!";
    }

    public String loginId(MemberLoginDto memberLoginDto) {
        Member member = memberRepository.Login(memberLoginDto.getId())
                .orElse(null);

        if (member == null) {
            return "존재하지 않는 아이디입니다.";
        }

        if (!passwordEncoder.matches(memberLoginDto.getPassword(), member.getPassword())) {
            return "비밀번호가 일치하지 않습니다.";
        }

        return "로그인 성공!";
    }
}
