package nc.deveo.pacific_athlete.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "workout")
public class Seance {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "date")
    private Instant date;

    @Column(name = "nom", length = Integer.MAX_VALUE)
    private String nom;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @Column(name = "utilisateur_id")
    private Long utilisateurId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "utilisateur_id", referencedColumnName = "id", updatable = false, insertable = false),
    })
    private Utilisateur utilisateur;
}