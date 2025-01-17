package planders.backend.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import planders.backend.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsById(Long id);
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
}