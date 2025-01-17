package planders.backend.member.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import planders.backend.member.dto.MemberRegistrationDto;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;
    private String email;
    private String nickname;
    private String gender;
    private Integer age;
    private String profileImageUrl;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    private Integer reportCount;

    public Member(MemberRegistrationDto dto) {
        this.id = dto.getId();
        this.password = dto.getPassword();
        this.email = dto.getEmail();
        this.nickname = dto.getNickname();
        this.gender = dto.getGender();
        this.age = dto.getAge();
        this.profileImageUrl = dto.getProfileImageUrl();
        this.reportCount = 0;
    }
}
