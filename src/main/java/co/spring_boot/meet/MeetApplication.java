package co.spring_boot.meet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeetApplication {

	private static final Logger logger = LoggerFactory.getLogger(MeetApplication.class);

	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion Meet");
		SpringApplication.run(MeetApplication.class, args);
	}

}
