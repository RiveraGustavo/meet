package co.spring_boot.meet.data;

import org.springframework.data.jpa.repository.JpaRepository;

import co.spring_boot.meet.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
}
