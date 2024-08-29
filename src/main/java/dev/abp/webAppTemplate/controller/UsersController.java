package dev.abp.webAppTemplate.controller;

import dev.abp.webAppTemplate.dto.Users;
import dev.abp.webAppTemplate.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return new ResponseEntity<List<Users>>(usersService.allUsers(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Optional<Users>> getSingleUser(@PathVariable String username) {
        return new ResponseEntity<Optional<Users>>(usersService.singleUser(username),HttpStatus.OK);
    }
}
