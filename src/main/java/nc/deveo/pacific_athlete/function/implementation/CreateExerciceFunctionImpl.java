package nc.deveo.pacific_athlete.function.implementation;

import lombok.RequiredArgsConstructor;
import nc.deveo.pacific_athlete.function.inputRequest.CreateExerciceInputRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class CreateExerciceFunctionImpl implements Function<CreateExerciceInputRequest, String> {

    @Override
    public String apply(CreateExerciceInputRequest numeroClient) {
        return "Nice";
    }
}
