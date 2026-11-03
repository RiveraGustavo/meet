package co.spring_boot.meet.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.spring_boot.meet.model.Meet;
import co.spring_boot.meet.model.Persona;

@Service
public class MeetServices {
    
    private static final List<Meet> meetings = new ArrayList<>();

    static {
        for (int idx = 0; idx < 5; idx++) {
            Meet meet = new Meet(idx, "Reunión " + idx, new java.util.Date()); 
            for (int i = 0; i < idx; i++) {
                meet.addParticipant(new Persona((long) i, "Participante " + i, "participante" + i + "@example.com", "123-456-789" + i ));
            }
            meetings.add( meet);
            
        }
    }

    public MeetServices() {
    }
    public List<Meet> getAllMeetings() {
        return meetings;
    }
}
