package co.spring_boot.meet.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import co.spring_boot.meet.Services.PersonaServices;

@Component
@Order (1)
public class DirectorioRunner implements CommandLineRunner {
    public static final Logger logger = LoggerFactory.getLogger(DirectorioRunner.class);

    @Autowired
    private PersonaServices personaServices;

    @Override
    public void run(String... args) throws Exception {
        logger.info("DirectorioRunner is running...");
        personaServices.getAllPersonas().forEach(persona -> {
            logger.info("Persona: {}", persona.toString());
        });
        logger.info("DirectorioRunner has finished running.");
    }
}