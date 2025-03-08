package nc.deveo.pacific_athlete.repository;

import nc.deveo.pacific_athlete.domain.Parametre;
import nc.deveo.pacific_athlete.domain.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParametreRepository extends JpaRepository<Parametre, Long> {
    List<Parametre> findAllByParamNameOrderByCreatedAtDesc(String paramName);
}
