package nc.deveo.pacific_athlete.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "workout_set")
public class WorkoutSet extends AbstractDomain {

    @Column(name = "workout_id")
    private Long workoutId;

    @Column(name = "mouvement_id")
    private Long exerciceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "exercice_id", referencedColumnName = "id", updatable = false, insertable = false),
    })
    private Exercice exercice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "workout_id", referencedColumnName = "id", updatable = false, insertable = false),
    })
    private Workout workout;

}