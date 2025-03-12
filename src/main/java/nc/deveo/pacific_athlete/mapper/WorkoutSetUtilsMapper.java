package nc.deveo.pacific_athlete.mapper;

import lombok.RequiredArgsConstructor;
import nc.deveo.pacific_athlete.domain.WorkoutSet;
import nc.deveo.pacific_athlete.repository.WorkoutSetLineRepository;
import nc.deveo.pacific_athlete.service.dto.WorkoutSetLineDto;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WorkoutSetUtilsMapper {
    private final WorkoutSetLineRepository workoutSetLineRepository;
    private final WorkoutSetLineMapper workoutSetLineMapper;

    @Named("getWorkoutLines")
    public List<WorkoutSetLineDto> getWorkoutLines(WorkoutSet set) {
        return workoutSetLineRepository.findAllByWorkoutSet_Id(set.getId()).stream().map(workoutSetLineMapper::toDto).toList();
    }

}
