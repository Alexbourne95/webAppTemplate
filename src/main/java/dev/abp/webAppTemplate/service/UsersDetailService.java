package dev.abp.webAppTemplate.service;


import dev.abp.webAppTemplate.dto.Users;
import dev.abp.webAppTemplate.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersDetailService implements UserDetailsService {

    private final UsersRepository usersRepository;

    public UsersDetailService(UsersRepository userRepository) {
        this.usersRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(users.getUsername())
                .password(users.getPassword()) // hashed password
                .roles(String.valueOf(users.getRoles())) // role should be something like "USER", "ADMIN", etc.
                .build();
    }
}

