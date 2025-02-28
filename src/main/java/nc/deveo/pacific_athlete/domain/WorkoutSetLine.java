package nc.deveo.pacific_athlete.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "workout_set_line")
public class WorkoutSetLine extends AbstractDomain {

    @Column(name = "workout_set_id")
    private Long workoutSetId;

    @Column(name = "reps")
    private Short reps;

    @Column(name = "weight")
    private Short weight;

    @Column(name = "distance")
    private Short distance;

    @Column(name = "\"time\"")
    private Long time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "workout_set_id", referencedColumnName = "id", updatable = false, insertable = false),
    })
    private WorkoutSet workoutSet;

}