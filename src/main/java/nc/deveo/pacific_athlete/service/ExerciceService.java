package nc.deveo.pacific_athlete.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nc.deveo.pacific_athlete.domain.Exercice;
import nc.deveo.pacific_athlete.domain.TypeExercice;
import nc.deveo.pacific_athlete.domain.Utilisateur;
import nc.deveo.pacific_athlete.mapper.ExerciceMapper;
import nc.deveo.pacific_athlete.repository.ExerciceRepository;
import nc.deveo.pacific_athlete.service.dto.ExerciceDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ExerciceService {

    private final UtilisateurService utilisateurService;
    private final ExerciceRepository repository;
    private final ExerciceMapper mapper;

    public List<ExerciceDto> getListExercice() {
        log.info("ExerciceService.getListExercice");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userUid = userDetails.getUsername();
        Utilisateur utilisateur = utilisateurService.getUtilisateurByUid(userUid);

        return repository.findAllByUtilisateurId(utilisateur.getId()).stream().map(mapper::toDto).toList();
    }

    @Transactional
    public ExerciceDto createExercice(String seanceNom, String description, TypeExercice type) {
        log.info("createMouvement: {} {} {}", seanceNom, type, description);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userUid = userDetails.getUsername();
        Utilisateur utilisateur = utilisateurService.getUtilisateurByUid(userUid);

        final Exercice exercice = new Exercice();
        exercice.setNom(seanceNom);
        exercice.setDescription(description);
        exercice.setType(type.name());
        exercice.setUtilisateurId(utilisateur.getId());
        final Exercice exerciceSaved = repository.save(exercice);
        return mapper.toDto(exerciceSaved);
    }
}
