package nc.deveo.pacific_athlete.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkoutSetLineDto {
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
}
