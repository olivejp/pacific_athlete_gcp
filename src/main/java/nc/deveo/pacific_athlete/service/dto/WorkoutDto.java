package nc.deveo.pacific_athlete.service.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class WorkoutDto {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDate dateExecution;
    private String description;
    private String imageUrl;
    private String timerType;
    private Long totalTime;
    private String typeWorkout;
    private String uid;
}
