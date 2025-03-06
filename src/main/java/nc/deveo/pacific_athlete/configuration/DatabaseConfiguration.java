package nc.deveo.pacific_athlete.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan(DatabaseConfiguration.DOMAIN_PATH)
@EnableJpaRepositories(basePackages = DatabaseConfiguration.REPOSITORY_PATH)
public class DatabaseConfiguration {
    public static final String DOMAIN_PATH = "nc.deveo.pacific_athlete.domain";
    public static final String REPOSITORY_PATH = "nc.deveo.pacific_athlete.repository";
}
