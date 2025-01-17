package planders.backend.trip.domain.todo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import planders.backend.trip.domain.Trip;

@Entity
@Table(name = "planders_todo")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    private String title;
    private String location;
}
