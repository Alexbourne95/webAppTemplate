package dev.abp.webAppTemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String landing() {
        return "landing";  // Returns the landing.html template
    }

    @GetMapping("/login")
    public String login() {
        return "login";  // Returns the login.html template
    }

    @GetMapping("/home")
    public String home() {
        return "home";  // Returns the home.html template after login
    }
}
