package nc.deveo.pacific_athlete.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "parametre")
public class Parametre {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "nom", length = Integer.MAX_VALUE)
    private String nom;

    @Column(name = "libelle", length = Integer.MAX_VALUE)
    private String libelle;

    @Column(name = "valeur", length = Integer.MAX_VALUE)
    private String valeur;

    @Column(name = "\"order\"")
    private Long order;

    @Column(name = "param_name", length = Integer.MAX_VALUE)
    private String paramName;

}