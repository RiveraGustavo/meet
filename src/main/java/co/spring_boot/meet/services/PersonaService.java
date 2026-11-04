package co.spring_boot.meet.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.spring_boot.meet.data.PersonaRepository;
import co.spring_boot.meet.model.Persona;

@Service 
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAllPersonas() {
        return this.personaRepository.findAll();
    }

    public Persona getPersonaById(long id) {
        return this.personaRepository.findById(id).orElse(null);
    }
}
