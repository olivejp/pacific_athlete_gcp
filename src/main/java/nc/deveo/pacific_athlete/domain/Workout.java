package nc.deveo.pacific_athlete.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "workout")
public class Workout extends AbstractDomain {

    @Column(name = "date_execution")
    private LocalDate dateExecution;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "image_url", length = Integer.MAX_VALUE)
    private String imageUrl;

    @Column(name = "timer_type", length = Integer.MAX_VALUE)
    private String timerType;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @Column(name = "total_time")
    private Long totalTime;

    @Column(name = "type_workout", length = Integer.MAX_VALUE)
    private String typeWorkout;

    @Column(name = "uid", length = Integer.MAX_VALUE)
    private String uid;

}