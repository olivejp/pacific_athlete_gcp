package nc.deveo.pacific_athlete.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExerciceDto {
    private Long id;
    private String nom;
    private String description;
    private String type;
    private String photoStorageUrl;
    private List<String> groupe;
    private LocalDateTime createdAt;
    private String origine;
}
