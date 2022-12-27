package com.example.gruppajava.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.gruppajava.entity.Car;
import com.example.gruppajava.entity.User;
import com.example.gruppajava.repository.CarRepository;
import com.example.gruppajava.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    UserRepository userRepository;
    CarRepository carRepository;

    public UserController(UserRepository userRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
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

    public record AddCarToUser(
            String licensePlateNr,
            String model,
            String email) {
    }

    @PostMapping("/api/users")
    public Car addUserCar(@RequestBody AddCarToUser req) {
        var newCar = new Car(
                req.licensePlateNr,
                req.model,
                userRepository.findByEmail(req.email).isPresent()
                        ? userRepository.findByEmail(req.email).get()
                        : null);

        return carRepository.save(newCar);

        // URI location = ServletUriComponentsBuilder
        // .fromCurrentRequest()
        // .path("/{id}")
        // .buildAndExpand(newCar.getId())
        // .toUri();

        // return ResponseEntity.created(location).body(newCar);
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
