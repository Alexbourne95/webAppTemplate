package dev.abp.webAppTemplate.controller;

import dev.abp.webAppTemplate.UsersRepository;
import dev.abp.webAppTemplate.dto.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SignupController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username,
                         @RequestParam String password,
                         RedirectAttributes redirectAttributes) {

        if (usersRepository.findUserByUsername(username).isPresent()) {
            redirectAttributes.addFlashAttribute("error", "Username already taken.");
            return "redirect:/signup";
        }

        Users newUser = new Users();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setRoles("ROLE_USER");  // Default role for non-admin signups

        usersRepository.save(newUser);

        redirectAttributes.addFlashAttribute("success", "Sign up successful! You can now log in.");
        return "redirect:/login";
    }
}
