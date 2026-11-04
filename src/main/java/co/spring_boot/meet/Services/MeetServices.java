package co.spring_boot.meet.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.spring_boot.meet.data.MeetRepository;
import co.spring_boot.meet.model.Meet;

@Service
public class MeetServices {
    
    private final MeetRepository meetRepository;

    public MeetServices(MeetRepository meetRepository) {
        this.meetRepository = meetRepository;
    }
    public List<Meet> getAllMeetings() {
        return this.meetRepository.findAll();
    }
}
