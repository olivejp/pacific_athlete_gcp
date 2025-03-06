package nc.deveo.pacific_athlete.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nc.deveo.pacific_athlete.domain.Exercice;
import nc.deveo.pacific_athlete.domain.TypeExercice;
import nc.deveo.pacific_athlete.mapper.ExerciceMapper;
import nc.deveo.pacific_athlete.repository.ExerciceRepository;
import nc.deveo.pacific_athlete.service.dto.ExerciceDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ExerciceService {

    private final ExerciceRepository repository;
    private final ExerciceMapper mapper;

    public List<ExerciceDto> getListExercice(Long utilisateurId) {
        log.info("getListMouvement: {}", utilisateurId);
        utilisateurId = 2L; // TODO remplacer cette assignation par une recherche dans un repository.
        return repository.findAllByUtilisateurId(utilisateurId).stream().map(mapper::toDto).toList();
    }

    @Transactional
    public ExerciceDto createExercice(String seanceNom, String description, TypeExercice type) {
        log.info("createMouvement: {} {} {}", seanceNom, type, description);
        final Long utilisateurId = 2L; // TODO remplacer cette assignation par une recherche dans un repository.
        final Exercice exercice = new Exercice();
        exercice.setNom(seanceNom);
        exercice.setDescription(description);
        exercice.setType(type.name());
        exercice.setUtilisateurId(utilisateurId);
        final Exercice exerciceSaved = repository.save(exercice);
        return mapper.toDto(exerciceSaved);
    }
}
