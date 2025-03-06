package nc.deveo.pacific_athlete.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "workout_set_line")
public class WorkoutSetLine extends AbstractDomain {


    @Column(name = "checked")
    private Boolean checked;

    @Column(name = "distance")
    private Long distance;

    @Column(name = "distance_unit", length = Integer.MAX_VALUE)
    private String distanceUnit;

    @Column(name = "reps")
    private Long reps;

    @Column(name = "\"time\"")
    private Long time;

    @Column(name = "time_unit", length = Integer.MAX_VALUE)
    private String timeUnit;

    @Column(name = "weight")
    private Long weight;

    @Column(name = "weight_unit", length = Integer.MAX_VALUE)
    private String weightUnit;

    @Column(name = "rest_time")
    private Long restTime;

    @Column(name = "rest_time_unit", length = Integer.MAX_VALUE)
    private String restTimeUnit;

    @Column(name = "\"order\"")
    private Long order;

    @Column(name = "uid", length = Integer.MAX_VALUE)
    private String uid;

    @Column(name = "workout_set_uid", length = Integer.MAX_VALUE)
    private String workoutSetUid;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "workout_set_id")
    private WorkoutSet workoutSet;

}