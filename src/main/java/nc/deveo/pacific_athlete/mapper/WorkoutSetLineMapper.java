package nc.deveo.pacific_athlete.mapper;

import nc.deveo.pacific_athlete.domain.WorkoutSetLine;
import nc.deveo.pacific_athlete.service.dto.WorkoutSetLineDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkoutSetLineMapper {
    @Mappings({
            @Mapping(target = "checked", source = "checked"),
            @Mapping(target = "distance", source = "distance"),
            @Mapping(target = "distanceUnit", source = "distanceUnit"),
            @Mapping(target = "reps", source = "reps"),
            @Mapping(target = "time", source = "time"),
            @Mapping(target = "timeUnit", source = "timeUnit"),
            @Mapping(target = "weight", source = "weight"),
            @Mapping(target = "weightUnit", source = "weightUnit"),
            @Mapping(target = "restTime", source = "restTime"),
            @Mapping(target = "order", source = "order"),
    })
    WorkoutSetLineDto toDto(WorkoutSetLine line);

    List<WorkoutSetLineDto> toDtos(List<WorkoutSetLine> lines);
}
