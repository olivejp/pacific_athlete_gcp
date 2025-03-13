package nc.deveo.pacific_athlete.repository;

import nc.deveo.pacific_athlete.domain.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, Long> {
    @Query(value = "SELECT e.* FROM exercice e WHERE e.origine = 'REF'", nativeQuery = true)
    List<Exercice> findAll();
}
