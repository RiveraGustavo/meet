package co.spring_boot.meet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.spring_boot.meet.model.Persona;
import co.spring_boot.meet.services.PersonaService;


@RestController 
@RequestMapping ("/api/personas")
public class PersonaRestController {

    private final PersonaService personaServices;

    public PersonaRestController(PersonaService personaServices) {
        this.personaServices = personaServices;
    }
    
    @GetMapping    
    public List<Persona> getAllPersonas() {
        return personaServices.getAllPersonas();
    }
}
