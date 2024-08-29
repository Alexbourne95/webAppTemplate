package dev.abp.webAppTemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String root() {
        return "redirect:/login";  // Redirect root URL to login page
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
