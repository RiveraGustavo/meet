package co.spring_boot.meet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.spring_boot.meet.services.PersonaService;

@Controller 
@RequestMapping ("/personas")
public class PersonaController {
    
    @Autowired 
    private PersonaService personaServices;

    @GetMapping
    public String getAllPersonas(Model model) {
        model.addAttribute("personas", personaServices.getAllPersonas());
        return "personas";
    }
}
