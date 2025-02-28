package nc.deveo.pacific_athlete.repository;

import nc.deveo.pacific_athlete.domain.WorkoutSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutSetRepository extends JpaRepository<WorkoutSet, Long> {
}
