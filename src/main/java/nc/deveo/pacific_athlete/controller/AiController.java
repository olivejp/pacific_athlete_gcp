package nc.deveo.pacific_athlete.controller;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import nc.deveo.pacific_athlete.service.AiService;
import nc.deveo.pacific_athlete.service.dto.AiResponseDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AiController {

    private final AiService aiService;

    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping("/generate")
    public AiResponseDto askAi(@RequestParam(name = "prompt") String request,
                               @Parameter(description = "Token JWT requis", required = true)
                               @RequestHeader("Authorization") String authorizationHeader) {
        return aiService.getPrompt(request);
    }

}
