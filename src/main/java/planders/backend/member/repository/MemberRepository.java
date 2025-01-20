package planders.backend.Member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import planders.backend.Member.domain.Member;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsById(Long id);
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);

    Optional<Member> Login(Long id);
}