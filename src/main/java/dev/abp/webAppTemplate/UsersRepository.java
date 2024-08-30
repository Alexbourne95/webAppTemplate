package dev.abp.webAppTemplate;

import dev.abp.webAppTemplate.dto.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
    Optional<Users> findUserByUsername(String username);
    Optional<Users> findUserByEmail(String email);


}
