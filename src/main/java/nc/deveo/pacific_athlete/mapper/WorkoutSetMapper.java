package nc.deveo.pacific_athlete.mapper;

import nc.deveo.pacific_athlete.domain.WorkoutSet;
import nc.deveo.pacific_athlete.service.dto.WorkoutSetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {WorkoutSetLineMapper.class})
public interface WorkoutSetMapper {
    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "createdAt", source = "createdAt"),
            @Mapping(target = "updatedAt", source = "updatedAt"),
            @Mapping(target = "commentaire", source = "commentaire"),
            @Mapping(target = "order", source = "order"),
            @Mapping(target = "exerciceUid", source = "exerciceUid"),
            @Mapping(target = "workoutUid", source = "workoutUid"),
            @Mapping(target = "weightUnit", source = "weightUnit"),
            @Mapping(target = "distanceUnit", source = "distanceUnit"),
            @Mapping(target = "timeUnit", source = "timeUnit"),
            @Mapping(target = "lines", source = "lines"),
    })
    WorkoutSetDto toDto(WorkoutSet set);

    List<WorkoutSetDto> toDtos(List<WorkoutSet> sets);
}
