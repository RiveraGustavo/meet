package co.spring_boot.meet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.spring_boot.meet.model.Persona;
import co.spring_boot.meet.services.PersonaServices;


@RestController 
@RequestMapping ("/api/personas")
public class PersonaRestController {

    private final PersonaServices personaServices;

    public PersonaRestController(PersonaServices personaServices) {
        this.personaServices = personaServices;
    }
    
    @GetMapping    
    public List<Persona> getAllPersonas() {
        return personaServices.getAllPersonas();
    }
}
