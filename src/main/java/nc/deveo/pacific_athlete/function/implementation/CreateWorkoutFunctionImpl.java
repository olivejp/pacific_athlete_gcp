package nc.deveo.pacific_athlete.function.implementation;

import lombok.RequiredArgsConstructor;
import nc.deveo.pacific_athlete.function.inputRequest.CreateWorkoutInputRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class CreateWorkoutFunctionImpl implements Function<CreateWorkoutInputRequest, String> {

    @Override
    public String apply(CreateWorkoutInputRequest numeroClient) {
        return "Nice";
    }
}
