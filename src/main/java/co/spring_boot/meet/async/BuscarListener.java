package co.spring_boot.meet.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import co.spring_boot.meet.model.Meet;
import co.spring_boot.meet.model.Persona;
import co.spring_boot.meet.services.MeetService;
import co.spring_boot.meet.services.PersonaService;
import tools.jackson.databind.ObjectMapper;

@Component
public class BuscarListener {
    private final  Logger logger = LoggerFactory.getLogger(BuscarListener.class);
    
    private final ObjectMapper objectMapper;
    private final PersonaService personaService;
    private final MeetService meetService;

    public BuscarListener(ObjectMapper objectMapper, PersonaService personaService, MeetService meetService) {
        this.objectMapper = objectMapper;
        this.personaService = personaService;
        this.meetService = meetService;
    }
    public void recibirMensaje(String mensaje) {
        try{
            logger.info("Mensaje recibido"); 
            InfoBuscar infoBuscar = objectMapper.readValue(mensaje, InfoBuscar.class);
            Persona persona = personaService.getPersonaById(infoBuscar.getIdAsistente());   
            Meet meet = meetService.getMeetById(infoBuscar.getIdReunion());
            logger.info("Persona: " + persona.getName() + " " + persona.getSecondName());
            logger.info("Reunión: " + meet.getName() + " " + meet.getDate().toString());    
        }catch (Exception e){
            logger.error("Error al recibir el mensaje", e);
        }
    }
}
