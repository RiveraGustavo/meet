package co.spring_boot.meet.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.spring_boot.meet.model.Persona;

@Service 
public class PersonaServices {
    private static final List<Persona> personas = new ArrayList<>();
    
    static {
        for (int idx = 0; idx < 5; idx++) {
            personas.add(new Persona((long) idx, "Persona " + idx, "persona" + idx + "@example.com", "123-456-789" + idx));
        }
    }

    public PersonaServices() {
    }
    
    public List<Persona> getAllPersonas() {
        return personas;
    }
}
