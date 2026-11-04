package co.spring_boot.meet.services;

import java.util.List;
import java.util.Optional;

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

    public Optional<Persona> getPersonaById(long id) {
        return this.personaRepository.findById(id);
    }
}
