package nc.deveo.pacific_athlete.repository;

import nc.deveo.pacific_athlete.domain.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, Long> {
    @Query(value = "SELECT e.* FROM exercice e LEFT JOIN utilisateur u ON e.utilisateur_id = u.id WHERE e.origine = 'REF' OR u.uid = :uid", nativeQuery = true)
    List<Exercice> findByOrigineOrUtilisateurUid(@Param("uid") String uid);
}
