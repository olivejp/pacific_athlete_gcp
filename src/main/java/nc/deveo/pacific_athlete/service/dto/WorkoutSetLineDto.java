package nc.deveo.pacific_athlete.service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkoutSetLineDto {
    private String uid;
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean checked;
    private Long distance;
    private String distanceUnit;
    private Long reps;
    private Long time;
    private String timeUnit;
    private Long weight;
    private String weightUnit;
    private Long restTime;
    private Long order;
    private String workoutSetUid;

}
