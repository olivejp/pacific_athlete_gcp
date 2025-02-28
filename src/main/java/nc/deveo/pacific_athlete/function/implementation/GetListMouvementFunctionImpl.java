package nc.deveo.pacific_athlete.function.implementation;

import lombok.RequiredArgsConstructor;
import nc.deveo.pacific_athlete.function.inputRequest.GetListMouvementInputRequest;
import nc.deveo.pacific_athlete.service.ExerciceService;
import nc.deveo.pacific_athlete.service.dto.ExerciceDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class GetListMouvementFunctionImpl implements Function<GetListMouvementInputRequest, List<ExerciceDto>> {

    private final ExerciceService exerciceService;

    @Override
    public List<ExerciceDto> apply(GetListMouvementInputRequest page) {
        final Long utilisateurId = 2L;
        return exerciceService.getListExercice(utilisateurId);
    }
}
