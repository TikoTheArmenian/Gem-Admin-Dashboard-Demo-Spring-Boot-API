package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // allow requests from this client
public class UserController {

    private final Map<String, User> users = new HashMap<>();

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        users.put(user.getUsername(), user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    @PostMapping("/clearUsers")
    public boolean clearUsers() {
        users.clear();
        return true;
    }

    @PostMapping("/editUser/{username}")
    public void editUser(@PathVariable String username, @RequestBody User updatedUser) {
        users.put(username, updatedUser);
    }
}

class User {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String username;
    private String email;
    private String description;


}
