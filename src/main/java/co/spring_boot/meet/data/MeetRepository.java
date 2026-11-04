package co.spring_boot.meet.data;

import org.springframework.data.jpa.repository.JpaRepository;

import co.spring_boot.meet.model.Meet;

public interface MeetRepository extends JpaRepository<Meet, Long>   {
    
}
