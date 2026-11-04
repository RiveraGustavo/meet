package co.spring_boot.meet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller 
public class AuthController {
    @GetMapping("/login_form")
    public String getLogin() {
        return "login_form";
    }
    
}
