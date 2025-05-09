package nc.deveo.pacific_athlete.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "nom", length = Integer.MAX_VALUE)
    private String nom;

    @Column(name = "email", length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "telephone1")
    private String telephone1;

    @Column(name = "description")
    private String description;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "sexe", length = Integer.MAX_VALUE)
    private String sexe;

    @Column(name = "uid", length = Integer.MAX_VALUE)
    private String uid;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @Column(name = "deleted_at")
    private OffsetDateTime deletedAt;

    @Column(name = "photo_storage_url", length = Integer.MAX_VALUE)
    private String photoStorageUrl;

}
