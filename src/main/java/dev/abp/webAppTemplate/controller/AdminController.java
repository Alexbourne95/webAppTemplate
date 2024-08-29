package dev.abp.webAppTemplate.controller;

import dev.abp.webAppTemplate.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")  // Ensure only admins can access these endpoints
public class AdminController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/admin")
    public String showUserRoles(Model model) {
        model.addAttribute("users", usersRepository.findAll());
        return "admin";
    }

    @PostMapping("/admin/changeRole")
    public String changeUserRole(@RequestParam String username, @RequestParam String role) {
        usersRepository.findUserByUsername(username).ifPresent(user -> {
            user.setRoles(role);
            usersRepository.save(user);
        });
        return "redirect:/admin";
    }
}
