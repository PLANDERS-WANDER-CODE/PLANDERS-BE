package planders.backend.trip.domain.plan;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import planders.backend.trip.domain.Trip;

import java.time.LocalDateTime;

@Entity
@Table(name = "planders_plan")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    private String description;
    private LocalDateTime dateTime;
}
