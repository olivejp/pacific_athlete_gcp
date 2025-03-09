package nc.deveo.pacific_athlete.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.lang.Collections;
import io.swagger.v3.oas.annotations.Parameter;
import nc.deveo.pacific_athlete.domain.Parametre;
import nc.deveo.pacific_athlete.repository.ParametreRepository;
import nc.deveo.pacific_athlete.service.dto.AiResponseDto;
import nc.deveo.pacific_athlete.service.dto.TypeResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.ResponseFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AiController {

    private final ChatClient chatClient;
    private final ParametreRepository parametreRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public AiController(ChatClient.Builder chatClientBuilder, ParametreRepository parametreRepository) {
        this.chatClient = chatClientBuilder.build();
        this.parametreRepository = parametreRepository;
    }

    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping("/generate")
    public AiResponseDto askAi(@RequestParam(name = "prompt") String request,
                               @Parameter(description = "Token JWT requis", required = true)
                               @RequestHeader("Authorization") String authorizationHeader) {
        try {
            String aiResponse = this.chatClient.prompt()
                    .user(getPromptFromDb(request))
                    .options(getOpenAiChatOptions())
                    .call()
                    .content();

            return objectMapper.readValue(aiResponse, AiResponseDto.class);
        } catch (Exception e) {
            return createAiResponseDtoFromException(e);
        }
    }

    private static AiResponseDto createAiResponseDtoFromException(Exception e) {
        AiResponseDto response = new AiResponseDto();
        response.setType(TypeResponse.ERROR);
        response.setMessage(e.getMessage());

        return response;
    }

    private String getPromptFromDb(String request) {
        final Optional<Parametre> parametreOptional = parametreRepository.findAllByParamNameOrderByCreatedAtDesc("PROMPT").stream().findFirst();
        final Parametre parametre = parametreOptional.orElseThrow(() -> new RuntimeException("No prompt found"));
        final PromptTemplate promptTemplate = new PromptTemplate(parametre.getValeur());
        promptTemplate.add("request", request);

        return promptTemplate.render();
    }

    private static OpenAiChatOptions getOpenAiChatOptions() {
        ResponseFormat responseFormat = new ResponseFormat();
        responseFormat.setType(ResponseFormat.Type.JSON_OBJECT);

        return OpenAiChatOptions.builder()
                .responseFormat(responseFormat)
                .functions(Collections.setOf("createWorkout", "createExercice", "getListExercice"))
                .build();
    }
}
