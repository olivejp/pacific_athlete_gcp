package nc.deveo.pacific_athlete.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nc.deveo.pacific_athlete.mapper.ExerciceMapper;
import nc.deveo.pacific_athlete.repository.ExerciceRepository;
import nc.deveo.pacific_athlete.service.dto.ExerciceDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ExerciceService {

    private final ExerciceRepository repository;
    private final ExerciceMapper mapper;
    private final ObjectMapper objectMapper;

    public String getListExercice() {
        log.info("ExerciceService.getListExercice");
        List<ExerciceDto> list = repository.findAll().stream().map(mapper::toDto).toList();
        try {
            String exerciceListAsString = objectMapper.writeValueAsString(list);
            log.info("ExerciceService.getListExercice: {}", exerciceListAsString);
            return exerciceListAsString;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
