package co.spring_boot.meet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.spring_boot.meet.model.Meet;
import co.spring_boot.meet.services.MeetServices;


@RestController 
@RequestMapping("/api/meetings")
public class MeetRestController {

    private final MeetServices meetServices;

    public MeetRestController(MeetServices meetServices) {
        this.meetServices = meetServices;
    }
    
    @GetMapping
    public List<Meet> getAllMeetings() {
        return meetServices.getAllMeetings();
    }
    
}
