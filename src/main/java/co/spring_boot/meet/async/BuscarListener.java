package co.spring_boot.meet.async;

import java.util.Optional;

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
            Optional<Persona> persona = personaService.getPersonaById(infoBuscar.getIdAsistente());   
            if(persona.isEmpty()){
                logger.warn("No se encontró la persona con ID: " + infoBuscar.getIdAsistente());
                return;
            }
            Optional<Meet> meet = meetService.getMeetById(infoBuscar.getIdReunion());
            if(meet.isEmpty()){
                logger.warn("No se encontró la reunión con ID: " + infoBuscar.getIdReunion());
                return;
            }
            if(persona.isPresent() && meet.isPresent()){
                 logger.info("Persona: " + persona.get().getName() + " " + persona.get().getSecondName());
                 logger.info("Reunión: " + meet.get().getName() + " " + meet.get().getDate().toString());    
            }
           
        }catch (Exception e){
            logger.error("Error al recibir el mensaje", e);
        }
    }
}
