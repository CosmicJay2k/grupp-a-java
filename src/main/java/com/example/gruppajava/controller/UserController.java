package com.example.gruppajava.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.gruppajava.entity.User;
import com.example.gruppajava.repository.UserRepository;

@RestController
public class UserController {

    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/api/user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        var newUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        return ResponseEntity.created(location).body(newUser);
    }

    @GetMapping("/api/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/api/user")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
