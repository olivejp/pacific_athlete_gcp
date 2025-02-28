package nc.deveo.pacific_athlete.service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExerciceDto {
    private Long id;
    private String nom;
    private String description;
    private String type;
    private LocalDateTime createdAt;
}
