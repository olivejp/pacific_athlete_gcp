package nc.deveo.pacific_athlete.function.implementation;

import lombok.RequiredArgsConstructor;
import nc.deveo.pacific_athlete.function.inputRequest.CreateWorkoutInputRequest;
import nc.deveo.pacific_athlete.service.WorkoutService;
import nc.deveo.pacific_athlete.service.dto.WorkoutDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class CreateWorkoutFunctionImpl implements Function<CreateWorkoutInputRequest, WorkoutDto> {

    private final WorkoutService workoutService;

    @Override
    public WorkoutDto apply(CreateWorkoutInputRequest inputRequest) {
        return workoutService.createWorkout(inputRequest);
    }
}
