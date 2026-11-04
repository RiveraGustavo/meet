package co.spring_boot.meet.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.spring_boot.meet.data.PersonaRepository;
import co.spring_boot.meet.model.Persona;

@Service 
public class PersonaServices {

    private final PersonaRepository personaRepository;

    public PersonaServices(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAllPersonas() {
        return this.personaRepository.findAll();
    }
}
