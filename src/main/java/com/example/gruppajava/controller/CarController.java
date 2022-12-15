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

import com.example.gruppajava.entity.Car;
import com.example.gruppajava.repository.CarRepository;
import com.example.gruppajava.repository.UserRepository;

@RestController
public class CarController {

  private final CarRepository carRepo;
  private final UserRepository userRepo;

  public CarController(CarRepository carRepo, UserRepository userRepo){
    this.carRepo = carRepo;
    this.userRepo = userRepo;
  }
  
  @GetMapping("/api/car")
  public List<Car> getAllCars(){     
    return  carRepo.findAll();
  }

  @GetMapping("/api/car/{id}")
  public Car getCar(@PathVariable Long id ){
    return carRepo.findById(id).get();
  }


//POST
  record addCarReq(
    String licensePlateNr,
    String model,
    Long userId
  ){}

  @PostMapping("/api/car")
  public ResponseEntity<Car> addCar(@RequestBody addCarReq req) {

    Car car = new Car( 
      req.licensePlateNr,
      req.model,
      userRepo.findById(req.userId).isPresent() 
        ? userRepo.findById(req.userId).get() 
        : null
    );

    carRepo.save(car);
    
    URI location = ServletUriComponentsBuilder
    .fromCurrentRequest()
    .path("/{id}")
    .buildAndExpand(car.getId())
    .toUri();
    
    return ResponseEntity.created(location).body(car);
  }
}