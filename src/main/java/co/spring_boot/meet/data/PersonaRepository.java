package co.spring_boot.meet.data;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import co.spring_boot.meet.model.Persona;

@RepositoryRestResource(path = "personas", collectionResourceRel = "personas")
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
}
