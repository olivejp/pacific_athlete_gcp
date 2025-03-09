package nc.deveo.pacific_athlete.function.inputRequest;

import lombok.Data;

import java.util.List;

@Data
public class CreateWorkoutInputRequest {
    List<Long> exercicesId;
    String description;
}
