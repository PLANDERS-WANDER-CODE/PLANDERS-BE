package planders.backend.trip.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import planders.backend.common.domain.TimeBaseEntity;
import planders.backend.trip.domain.temp.TempMember;

@Entity
@Table(name = "planders_trip")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Trip extends TimeBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;

    // 임시 멤버 엔티티와 연관관계 매핑
    @ManyToOne
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private TempMember member;

    @Embedded
    private TripInfo tripInfo;
    private String backgroundImageUrl;
    private String inviteCode;
}
