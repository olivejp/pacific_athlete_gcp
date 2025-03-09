package nc.deveo.pacific_athlete.service.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ExerciceDto {
    private Long id;
    private String nom;
    private String description;
    private String type;
    private String imageUrl;
    private List<String> groupe;
    private LocalDateTime createdAt;
    private String origine;
}
