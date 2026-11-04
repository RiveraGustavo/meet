package co.spring_boot.meet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.spring_boot.meet.services.MeetServices;

@Controller 
@RequestMapping ("/meetings")
public class MeetController {

    @Autowired
    private MeetServices meetServices;

    @GetMapping
    public String getAllMeetings(Model model) {
       model.addAttribute("meetings",meetServices.getAllMeetings()); 
       return "meetings";
    }
    
}
