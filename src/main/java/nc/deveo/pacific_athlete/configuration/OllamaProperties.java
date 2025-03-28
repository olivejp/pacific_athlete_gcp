package nc.deveo.pacific_athlete.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "ollama")
public class OllamaProperties {
    private final CorsConfiguration cors = new CorsConfiguration();
    private String secret;
}
