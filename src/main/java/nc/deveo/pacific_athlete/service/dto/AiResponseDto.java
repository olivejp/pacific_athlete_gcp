package nc.deveo.pacific_athlete.service.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AiResponseDto {
    private TypeResponse type;
    private String message;
    private Object data;
    private FitnessDataType dataType;
}
