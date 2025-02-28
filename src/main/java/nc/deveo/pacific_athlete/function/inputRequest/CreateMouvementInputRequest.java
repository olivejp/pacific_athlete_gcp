package nc.deveo.pacific_athlete.function.inputRequest;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import nc.deveo.pacific_athlete.domain.TypeMouvement;

@Data
public class CreateMouvementInputRequest {
    @NotNull
    private String nom;

    @NotNull
    private String description;

    @NotNull
    private TypeMouvement typeMouvement;
}
