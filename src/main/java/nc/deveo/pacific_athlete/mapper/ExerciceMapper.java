package nc.deveo.pacific_athlete.mapper;

import nc.deveo.pacific_athlete.domain.Exercice;
import nc.deveo.pacific_athlete.service.dto.ExerciceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ExerciceMapper {
    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "nom", source = "nom"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "type", source = "type"),
            @Mapping(target = "createdAt", source = "createdAt"),
    })
    ExerciceDto toDto(Exercice exercice);
}
