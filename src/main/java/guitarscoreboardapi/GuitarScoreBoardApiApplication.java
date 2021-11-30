package guitarscoreboardapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GuitarScoreBoardApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuitarScoreBoardApiApplication.class, args);
	}

}
