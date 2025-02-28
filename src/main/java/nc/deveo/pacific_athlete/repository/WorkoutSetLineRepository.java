package nc.deveo.pacific_athlete.repository;

import nc.deveo.pacific_athlete.domain.WorkoutSetLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutSetLineRepository extends JpaRepository<WorkoutSetLine, Long> {
}
