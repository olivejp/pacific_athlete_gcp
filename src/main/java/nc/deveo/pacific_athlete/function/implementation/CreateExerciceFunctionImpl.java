package nc.deveo.pacific_athlete.function.implementation;

import lombok.RequiredArgsConstructor;
import nc.deveo.pacific_athlete.function.inputRequest.CreateExerciceInputRequest;
import nc.deveo.pacific_athlete.service.ExerciceService;
import nc.deveo.pacific_athlete.service.dto.ExerciceDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class CreateExerciceFunctionImpl implements Function<CreateExerciceInputRequest, ExerciceDto> {

    private final ExerciceService exerciceService;

    @Override
    public ExerciceDto apply(CreateExerciceInputRequest request) {
        return exerciceService.createExercice(request.getNom(), request.getDescription(), request.getTypeExercice());
    }
}
