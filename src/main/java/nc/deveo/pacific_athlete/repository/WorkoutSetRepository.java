package nc.deveo.pacific_athlete.repository;

import nc.deveo.pacific_athlete.domain.WorkoutSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutSetRepository extends JpaRepository<WorkoutSet, Long> {
    List<WorkoutSet> findAllByWorkout_Id(Long id);
}
