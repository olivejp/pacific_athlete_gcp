package nc.deveo.pacific_athlete.service.dto;

import lombok.Data;

@Data
public class AiResponseDto {
    private TypeResponse type;
    private String message;
    private Object data;
    private FitnessDataType dataType;
}
