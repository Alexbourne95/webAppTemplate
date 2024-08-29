package dev.abp.webAppTemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // This should point to a `home.html` file in the templates folder
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Points to the `login.html`
    }
}
