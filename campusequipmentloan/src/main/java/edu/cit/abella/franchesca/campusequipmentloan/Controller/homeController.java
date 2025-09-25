package edu.cit.abella.franchesca.campusequipmentloan.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {
        @GetMapping("/home")
    public String home(){
            return "Welcome! You are logged in.";
        }
}
