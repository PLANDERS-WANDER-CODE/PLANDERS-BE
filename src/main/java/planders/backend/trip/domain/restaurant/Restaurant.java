package planders.backend.trip.domain.restaurant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import planders.backend.trip.domain.Trip;

@Entity
@Table(name = "planders_restaurant")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    private String breakfast;
    private String lunch;
    private String dinner;
}
