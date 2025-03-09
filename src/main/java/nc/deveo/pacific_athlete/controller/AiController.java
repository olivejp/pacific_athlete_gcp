package nc.deveo.pacific_athlete.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.ai.openai.api.ResponseFormat;

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
    public AiResponseDto askAi(@RequestParam(name = "prompt") String prompt,
                               @Parameter(description = "Token JWT requis", required = true)
                               @RequestHeader("Authorization") String authorizationHeader) {
        try {
            final Optional<Parametre> parametreOptional = parametreRepository.findAllByParamNameOrderByCreatedAtDesc("PROMPT").stream().findFirst();
            final Parametre parametre = parametreOptional.orElseThrow(() -> new RuntimeException("No prompt found"));
            final PromptTemplate promptTemplate = new PromptTemplate(parametre.getValeur());
            promptTemplate.add("request", prompt);
            final String question = promptTemplate.render();

            ResponseFormat responseFormat = new ResponseFormat();
            responseFormat.setType(ResponseFormat.Type.JSON_OBJECT);

            OpenAiChatOptions options = OpenAiChatOptions.builder()
                    .responseFormat(responseFormat)
                    .functions(Collections.setOf("createWorkout", "createExercice", "getListExercice"))
                    .build();

            String aiResponse = this.chatClient.prompt()
                    .user(question)
                    .options(options)
                    .call()
                    .content();

            // Dé sérialisation de la réponse de l'IA
            return objectMapper.readValue(aiResponse, AiResponseDto.class);
        } catch (JsonProcessingException e) {
            AiResponseDto response = new AiResponseDto();
            response.setType(TypeResponse.ERROR);
            response.setMessage(e.getMessage());
            return response;
        }
    }
}
