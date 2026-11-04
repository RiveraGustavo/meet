package co.spring_boot.meet.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import co.spring_boot.meet.model.Meet;

@RepositoryRestResource(path = "meets", collectionResourceRel = "meets")
public interface MeetRepository extends JpaRepository<Meet, Long>   {
    
}
