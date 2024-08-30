package dev.abp.webAppTemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    private ObjectId id;
    private String username;
    private String email;
    private String password; //Hashed
    private ArrayList<String> roles;
    private String created_at;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = (ArrayList<String>) roles;
    }
}
