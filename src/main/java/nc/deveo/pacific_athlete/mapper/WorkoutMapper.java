package nc.deveo.pacific_athlete.mapper;

import nc.deveo.pacific_athlete.domain.Workout;
import nc.deveo.pacific_athlete.service.dto.WorkoutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkoutMapper {
    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "createdAt", source = "createdAt"),
            @Mapping(target = "updatedAt", source = "updatedAt"),
            @Mapping(target = "dateExecution", source = "dateExecution"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "imageUrl", source = "imageUrl"),
            @Mapping(target = "timerType", source = "timerType"),
            @Mapping(target = "totalTime", source = "totalTime"),
            @Mapping(target = "typeWorkout", source = "typeWorkout"),
            @Mapping(target = "uid", source = "uid"),
    })
    WorkoutDto toDto(Workout workout);

    List<WorkoutDto> toDtos(List<Workout> allByUtilisateurId);
}
