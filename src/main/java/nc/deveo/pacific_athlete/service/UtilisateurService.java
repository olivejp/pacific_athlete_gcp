package nc.deveo.pacific_athlete.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nc.deveo.pacific_athlete.domain.Utilisateur;
import nc.deveo.pacific_athlete.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    public Utilisateur getUtilisateur(Long id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    public Utilisateur getUtilisateurByEmail(String email) {
        return utilisateurRepository.findByEmail(email).orElse(null);
    }

    public Utilisateur getUtilisateurByUid(String userUid) {
        return utilisateurRepository.findByUid(userUid).orElse(null);
    }
}
