package nc.deveo.pacific_athlete.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "workout")
public class Workout extends AbstractDomain {

    @Column(name = "type", length = Integer.MAX_VALUE)
    private String type;

    @Column(name = "seance_id")
    private Long seanceId;

    @Column(name = "ordre")
    private Short ordre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "exercice_id", referencedColumnName = "id", updatable = false, insertable = false),
    })
    private Exercice exercice;

}