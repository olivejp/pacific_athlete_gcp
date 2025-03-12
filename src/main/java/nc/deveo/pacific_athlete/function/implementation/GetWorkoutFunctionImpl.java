package nc.deveo.pacific_athlete.function.implementation;

import lombok.RequiredArgsConstructor;
import nc.deveo.pacific_athlete.function.inputRequest.GetWorkoutInputRequest;
import nc.deveo.pacific_athlete.service.WorkoutService;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class GetWorkoutFunctionImpl implements Function<GetWorkoutInputRequest, String> {

    private final WorkoutService workoutService;

    @Override
    public String apply(GetWorkoutInputRequest inputRequest) {
        return workoutService.getWorkout(inputRequest);
    }
}
