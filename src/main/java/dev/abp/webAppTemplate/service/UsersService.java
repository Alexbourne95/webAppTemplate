package dev.abp.webAppTemplate.service;

import dev.abp.webAppTemplate.dto.Users;
import dev.abp.webAppTemplate.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    public List<Users> allUsers(){
        return usersRepository.findAll();
    }
    public Optional<Users> singleUser(String username){
        return usersRepository.findUserByUsername(username);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(String username, String password, ArrayList<String> role) {
        String encodedPassword = passwordEncoder.encode(password);
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(encodedPassword);
        users.setRoles(role);
        usersRepository.save(users);
    }
}
