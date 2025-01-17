package planders.backend.trip.domain.cost;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import planders.backend.trip.domain.Trip;

@Entity
@Table(name = "planders_cost")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    private String vehicle;
    private Integer price;
}
