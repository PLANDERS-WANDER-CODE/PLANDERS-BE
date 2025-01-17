package planders.backend.trip.domain.prepare;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import planders.backend.trip.domain.Trip;

@Entity
@Table(name = "planders_prepare")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Prepare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    private String name;
}
