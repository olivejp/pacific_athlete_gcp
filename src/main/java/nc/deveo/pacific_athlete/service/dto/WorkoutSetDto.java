package nc.deveo.pacific_athlete.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkoutSetDto {
    private String commentaire;
    private Long order;
    private String exerciceUid;
    private String workoutUid;
    private String weightUnit;
    private String distanceUnit;
    private String timeUnit;
    private List<WorkoutSetLineDto> lines;
}
