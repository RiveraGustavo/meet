package co.spring_boot.meet.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.spring_boot.meet.data.MeetRepository;
import co.spring_boot.meet.model.Meet;

@Service
public class MeetService {
    
    private final MeetRepository meetRepository;

    public MeetService(MeetRepository meetRepository) {
        this.meetRepository = meetRepository;
    }
    public List<Meet> getAllMeetings() {
        return this.meetRepository.findAll();
    }
    public Meet getMeetById(long id) {
        return this.meetRepository.findById(id).orElse(null);
    }
}
