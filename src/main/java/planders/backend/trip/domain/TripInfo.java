package planders.backend.trip.domain;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class TripInfo {

    private String title;
    private String description;
    private int participantCount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
}
