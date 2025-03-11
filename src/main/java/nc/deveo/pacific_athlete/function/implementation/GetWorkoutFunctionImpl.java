package nc.deveo.pacific_athlete.function.implementation;

import lombok.RequiredArgsConstructor;
import nc.deveo.pacific_athlete.function.inputRequest.GetWorkoutInputRequest;
import nc.deveo.pacific_athlete.service.WorkoutService;
import nc.deveo.pacific_athlete.service.dto.WorkoutDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class GetWorkoutFunctionImpl implements Function<GetWorkoutInputRequest, List<WorkoutDto>> {

    private final WorkoutService workoutService;

    @Override
    public List<WorkoutDto> apply(GetWorkoutInputRequest inputRequest) {
        return workoutService.getWorkout(inputRequest);
    }
}
