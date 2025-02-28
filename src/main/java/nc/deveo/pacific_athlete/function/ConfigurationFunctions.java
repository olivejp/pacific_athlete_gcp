package nc.deveo.pacific_athlete.function;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nc.deveo.pacific_athlete.function.implementation.CreateExerciceFunctionImpl;
import nc.deveo.pacific_athlete.function.implementation.CreateMouvementFunctionImpl;
import nc.deveo.pacific_athlete.function.implementation.GetListMouvementFunctionImpl;
import nc.deveo.pacific_athlete.function.inputRequest.CreateExerciceInputRequest;
import nc.deveo.pacific_athlete.function.inputRequest.CreateMouvementInputRequest;
import nc.deveo.pacific_athlete.function.inputRequest.GetListMouvementInputRequest;
import org.springframework.ai.model.function.FunctionCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
@RequiredArgsConstructor
public class ConfigurationFunctions {

    private final CreateExerciceFunctionImpl createExerciceFunction;
    private final CreateMouvementFunctionImpl createMouvementFunction;
    private final GetListMouvementFunctionImpl getListMouvementFunction;

    @Bean
    public FunctionCallback createExerciceFunction() {
        return FunctionCallback.builder()
                .function("createExercice", createExerciceFunction)
                .inputType(CreateExerciceInputRequest.class)
                .description("Create an exercice")
                .build();
    }

    @Bean
    public FunctionCallback createMouvementFunction() {
        return FunctionCallback.builder()
                .function("createMouvement", createMouvementFunction)
                .inputType(CreateMouvementInputRequest.class)
                .description("This function helps you create a mouvement.")
                .build();
    }

    @Bean
    public FunctionCallback getListMouvementFunction() {
        return FunctionCallback.builder()
                .function("getListMouvement", getListMouvementFunction)
                .description("This function helps you get the list of mouvement.")
                .inputType(GetListMouvementInputRequest.class)
                .build();
    }
}
