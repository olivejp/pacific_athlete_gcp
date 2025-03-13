package nc.deveo.pacific_athlete.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    @Column(name = "origine", length = Integer.MAX_VALUE)
    private String origine;

    @Column(name = "type", length = Integer.MAX_VALUE)
    private String type;

    @Column(name = "uid", length = Integer.MAX_VALUE)
    private String uid;

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "groupe", columnDefinition = "TEXT[]")
    private List<String> groupe;

    @Column(name = "photo_storage_url", length = Integer.MAX_VALUE)
    private String photoStorageUrl;

}