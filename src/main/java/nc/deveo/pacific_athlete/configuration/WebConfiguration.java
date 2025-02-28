package nc.deveo.pacific_athlete.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class WebConfiguration {

    @Bean
    @Primary
    public CorsConfigurationSource corsConfigurationSource(final OllamaProperties properties) {
        final CorsConfiguration config = properties.getCors();
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        source.registerCorsConfiguration("/v3/api-docs", config);
        source.registerCorsConfiguration("/api-docs", config);
        return source;
    }
}
