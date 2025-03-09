package nc.deveo.pacific_athlete.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nc.deveo.pacific_athlete.domain.Exercice;
import nc.deveo.pacific_athlete.domain.Utilisateur;
import nc.deveo.pacific_athlete.domain.Workout;
import nc.deveo.pacific_athlete.domain.WorkoutSet;
import nc.deveo.pacific_athlete.function.inputRequest.CreateWorkoutInputRequest;
import nc.deveo.pacific_athlete.mapper.WorkoutMapper;
import nc.deveo.pacific_athlete.repository.ExerciceRepository;
import nc.deveo.pacific_athlete.repository.UtilisateurRepository;
import nc.deveo.pacific_athlete.repository.WorkoutRepository;
import nc.deveo.pacific_athlete.repository.WorkoutSetRepository;
import nc.deveo.pacific_athlete.service.dto.WorkoutDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class WorkoutService {
    private final WorkoutRepository workoutRepository;
    private final WorkoutSetRepository workoutSetRepository;
    private final ExerciceRepository exerciceRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final WorkoutMapper workoutMapper;

    public WorkoutDto createWorkout(CreateWorkoutInputRequest inputRequest) {
        log.info("Creating workout {}", inputRequest);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userUid = userDetails.getUsername();

        Utilisateur utilisateur = utilisateurRepository.findByUid(userUid).orElseThrow(() -> new RuntimeException("User not found"));

        Workout workout = new Workout();
        workout.setUid(UUID.randomUUID().toString());
        workout.setUtilisateur(utilisateur);
        workout.setDateExecution(LocalDate.now());
        workout.setDescription(inputRequest.getDescription());
        workoutRepository.save(workout);

        List<Exercice> exercices = exerciceRepository.findAllById(inputRequest.getExercicesId());
        Long order = 1L;
        for (Exercice exercice : exercices) {
            WorkoutSet workoutSet = new WorkoutSet();
            workoutSet.setUid(UUID.randomUUID().toString());
            workoutSet.setOrder(order);
            workoutSet.setExercice(exercice);
            workoutSet.setWorkout(workout);
            workoutSetRepository.save(workoutSet);
            order++;
        }

        return workoutMapper.toDto(workout);
    }
}
