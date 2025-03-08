package nc.deveo.pacific_athlete.controller;

import nc.deveo.pacific_athlete.domain.Parametre;
import nc.deveo.pacific_athlete.repository.ParametreRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AiController {

    private final ChatClient chatClient;
    private final ParametreRepository parametreRepository;

    public AiController(ChatClient.Builder chatClientBuilder, ParametreRepository parametreRepository) {
        this.chatClient = chatClientBuilder.build();
        this.parametreRepository = parametreRepository;
    }

    @PostMapping("/generate")
    public String askAi(@RequestParam(name = "prompt") String prompt) {
        final Optional<Parametre> parametreOptional = parametreRepository.findAllByParamNameOrderByCreatedAtDesc("PROMPT").stream().findFirst();
        final Parametre parametre = parametreOptional.orElseThrow(() -> new RuntimeException("No prompt found"));
        final PromptTemplate promptTemplate = new PromptTemplate(parametre.getValeur());
        promptTemplate.add("request", prompt);
        final String question = promptTemplate.render();
        return this.chatClient.prompt()
                .user(question)
                .functions("createWorkout", "createExercice", "getListExercice")
                .call()
                .content();
    }
}
