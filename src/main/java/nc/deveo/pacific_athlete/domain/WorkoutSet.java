package nc.deveo.pacific_athlete.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "workout_set")
public class WorkoutSet extends AbstractDomain {


    @Column(name = "commentaire", length = Integer.MAX_VALUE)
    private String commentaire;

    @Column(name = "\"order\"")
    private Long order;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "workout_id", nullable = false, referencedColumnName = "id")
    private Workout workout;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercice_id")
    private Exercice exercice;

    @Column(name = "uid", length = Integer.MAX_VALUE)
    private String uid;

    @Column(name = "exercice_uid", length = Integer.MAX_VALUE)
    private String exerciceUid;

    @Column(name = "workout_uid", length = Integer.MAX_VALUE)
    private String workoutUid;

    @Column(name = "weight_unit", length = Integer.MAX_VALUE)
    private String weightUnit;

    @Column(name = "distance_unit", length = Integer.MAX_VALUE)
    private String distanceUnit;

    @Column(name = "time_unit", length = Integer.MAX_VALUE)
    private String timeUnit;

    @OneToMany(mappedBy = "workoutSet", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("workoutSet")
    private Set<WorkoutSetLine> lines;
}