package nc.deveo.pacific_athlete.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "exercice")
public class Exercice extends AbstractDomain {

    @Column(name = "nom", length = Integer.MAX_VALUE)
    private String nom;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "video_url", length = Integer.MAX_VALUE)
    private String videoUrl;

    @Column(name = "youtube_url", length = Integer.MAX_VALUE)
    private String youtubeUrl;

    @Column(name = "image_url", length = Integer.MAX_VALUE)
    private String imageUrl;

    @Column(name = "origine", length = Integer.MAX_VALUE)
    private String origine;

    @Column(name = "type", length = Integer.MAX_VALUE)
    private String type;

    @Column(name = "utilisateur_id")
    private Long utilisateurId;

    @Column(name = "uid", length = Integer.MAX_VALUE)
    private String uid;

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "groupe", columnDefinition = "TEXT[]")
    private List<String> groupe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "utilisateur_id", referencedColumnName = "id", updatable = false, insertable = false),
    })
    private Utilisateur utilisateur;
}