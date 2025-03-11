package nc.deveo.pacific_athlete.function;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nc.deveo.pacific_athlete.function.implementation.CreateWorkoutFunctionImpl;
import nc.deveo.pacific_athlete.function.implementation.CreateExerciceFunctionImpl;
import nc.deveo.pacific_athlete.function.implementation.GetListExerciceFunctionImpl;
import nc.deveo.pacific_athlete.function.implementation.GetWorkoutFunctionImpl;
import nc.deveo.pacific_athlete.function.inputRequest.CreateWorkoutInputRequest;
import nc.deveo.pacific_athlete.function.inputRequest.CreateExerciceInputRequest;
import nc.deveo.pacific_athlete.function.inputRequest.GetListExerciceInputRequest;
import nc.deveo.pacific_athlete.function.inputRequest.GetWorkoutInputRequest;
import org.springframework.ai.model.function.FunctionCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
@RequiredArgsConstructor
public class ConfigurationFunctions {

    private final CreateWorkoutFunctionImpl createWorkoutFunction;
    private final GetWorkoutFunctionImpl getWorkoutFunction;
    private final CreateExerciceFunctionImpl createExerciceFunction;
    private final GetListExerciceFunctionImpl getListExerciceFunction;

    @Bean
    public FunctionCallback createWorkoutFunction() {
        return FunctionCallback.builder()
                .function("createWorkout", createWorkoutFunction)
                .inputType(CreateWorkoutInputRequest.class)
                .description("Create an workout")
                .build();
    }

    @Bean
    public FunctionCallback getWorkoutFunction() {
        return FunctionCallback.builder()
                .function("getWorkout", getWorkoutFunction)
                .inputType(GetWorkoutInputRequest.class)
                .description("Get a list of workout")
                .build();
    }

    @Bean
    public FunctionCallback createExerciceFunction() {
        return FunctionCallback.builder()
                .function("createExercice", createExerciceFunction)
                .inputType(CreateExerciceInputRequest.class)
                .description("This function helps you create an exercise.")
                .build();
    }

    @Bean
    public FunctionCallback getListExerciceFunction() {
        return FunctionCallback.builder()
                .function("getListExercice", getListExerciceFunction)
                .description("This function helps you get the list of exercise.")
                .inputType(GetListExerciceInputRequest.class)
                .build();
    }
}
