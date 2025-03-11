package nc.deveo.pacific_athlete.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.lang.Collections;
import nc.deveo.pacific_athlete.domain.Parametre;
import nc.deveo.pacific_athlete.repository.ParametreRepository;
import nc.deveo.pacific_athlete.service.dto.AiResponseDto;
import nc.deveo.pacific_athlete.service.dto.TypeResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.ResponseFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AiService {
    private final ChatClient chatClient;
    private final ParametreRepository parametreRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public AiService(ChatClient.Builder chatClientBuilder, ParametreRepository parametreRepository) {
        this.chatClient = chatClientBuilder.build();
        this.parametreRepository = parametreRepository;
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
                .functions(Collections.setOf("createWorkout", "createExercice", "getListExercice", "getWorkout"))
                .build();
    }

    /**
     * Generates a response from the AI based on the provided request.
     *
     * @param request the input prompt to be sent to the AI
     * @return an {@link AiResponseDto} containing the AI's response
     */
    public AiResponseDto getPrompt(String request) {
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
}
