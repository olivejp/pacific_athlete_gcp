package nc.deveo.pacific_athlete.service.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class WorkoutSetDto {
    private Long id;
    private String uid;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String commentaire;
    private Long order;
    private String exerciceUid;
    private String workoutUid;
    private String weightUnit;
    private String distanceUnit;
    private String timeUnit;
    private List<WorkoutSetLineDto> lines;
}
