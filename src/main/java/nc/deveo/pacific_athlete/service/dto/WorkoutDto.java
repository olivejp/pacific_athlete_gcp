package nc.deveo.pacific_athlete.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkoutDto {
    private Long id;
    private LocalDate dateExecution;
    private String description;
    private String imageUrl;
    private String timerType;
    private String typeWorkout;
    private String uid;
    private List<WorkoutSetDto> sets;
}
