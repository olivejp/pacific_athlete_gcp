package nc.deveo.pacific_athlete.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OllamaController {

    private final ChatClient chatClient;

    public OllamaController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @PostMapping("/generate")
    public String generateOllama(@RequestParam(name = "prompt") String prompt) {
        final PromptTemplate promptTemplate = new PromptTemplate("All you answer will be in JSON format and nothing more." +
                "Try to use the functions included with this request in priority." +
                "If you use one of the functions then return directly the result of the function without any changes." +
                "You will not add notes nor observations." +
                "Your answer should not begins with ```json." +
                "Here is my request : {request}");
        promptTemplate.add("request", prompt);
        final String question = promptTemplate.render();
        return this.chatClient.prompt()
                .user(question)
                .functions("createExercice", "createMouvement", "getListMouvement")
                .call()
                .content();
    }
}
