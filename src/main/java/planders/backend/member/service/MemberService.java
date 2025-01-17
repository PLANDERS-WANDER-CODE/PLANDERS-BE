package planders.backend.member.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import planders.backend.member.domain.Member;
import planders.backend.member.dto.MemberRegistrationDto;
import planders.backend.member.repository.MemberRepository;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public String resgister(MemberRegistrationDto memberRegistrationDto ) {
        // 아이디 중복체크
        if (memberRepository.existsById(memberRegistrationDto.getId())){
            return "아이디가 이미 존재합니다!";
        }

        // 이메일 중복 체크
        if (memberRepository.existsByEmail(memberRegistrationDto.getEmail())){
            return "이메일이 이미 존재합니다!";
        }

        // 닉네임 중복 체크
        if (memberRepository.existsByNickname(memberRegistrationDto.getNickname())){
            return "닉네임이 이미 존재합니다!";
        }

        Member member = Member.builder()
                .password(memberRegistrationDto.getPassword())
                .email(memberRegistrationDto.getEmail())
                .nickname(memberRegistrationDto.getNickname())
                .gender(memberRegistrationDto.getGender())
                .age(memberRegistrationDto.getAge())
                .profileImageUrl(memberRegistrationDto.getProfileImageUrl())
                .reportCount(0)
                .build();

        memberRepository.save(member);  // DB에 회원 정보 저장

        return "회원가입 성공!";
    }
}
