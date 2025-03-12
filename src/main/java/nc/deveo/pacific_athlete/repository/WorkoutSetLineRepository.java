package nc.deveo.pacific_athlete.repository;

import nc.deveo.pacific_athlete.domain.WorkoutSetLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutSetLineRepository extends JpaRepository<WorkoutSetLine, Long> {
    List<WorkoutSetLine> findAllByWorkoutSet_Id(Long id);
}
