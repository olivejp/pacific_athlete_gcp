package nc.deveo.pacific_athlete.mapper;

import lombok.RequiredArgsConstructor;
import nc.deveo.pacific_athlete.domain.Workout;
import nc.deveo.pacific_athlete.repository.WorkoutSetRepository;
import nc.deveo.pacific_athlete.service.dto.WorkoutSetDto;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WorkoutUtilsMapper {

    private final WorkoutSetRepository workoutSetRepository;
    private final WorkoutSetMapper workoutSetMapper;

    @Named("getWorkoutSets")
    public List<WorkoutSetDto> getWorkoutSets(Workout workout) {
        return workoutSetRepository.findAllByWorkout_Id(workout.getId()).stream().map(workoutSetMapper::toDto).toList();
    }
}
