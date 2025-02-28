package nc.deveo.pacific_athlete.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "exercice")
public class Exercice extends AbstractDomain {

    @Column(name = "nom", length = Integer.MAX_VALUE)
    private String nom;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "type", length = Integer.MAX_VALUE)
    private String type;

    @Column(name = "utilisateur_id")
    private Long utilisateurId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "utilisateur_id", referencedColumnName = "id", updatable = false, insertable = false),
    })
    private Utilisateur utilisateur;
}