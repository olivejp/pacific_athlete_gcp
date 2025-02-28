package nc.deveo.pacific_athlete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class PacificAthleteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacificAthleteApplication.class, args);
	}

}
