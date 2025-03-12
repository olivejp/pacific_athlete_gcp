package nc.deveo.pacific_athlete.function.implementation;

import lombok.RequiredArgsConstructor;
import nc.deveo.pacific_athlete.function.inputRequest.GetListExerciceInputRequest;
import nc.deveo.pacific_athlete.service.ExerciceService;
import nc.deveo.pacific_athlete.service.dto.ExerciceDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class GetListExerciceFunctionImpl implements Function<GetListExerciceInputRequest, String> {

    private final ExerciceService exerciceService;

    @Override
    public String apply(GetListExerciceInputRequest page) {
        return exerciceService.getListExercice();
    }
}
