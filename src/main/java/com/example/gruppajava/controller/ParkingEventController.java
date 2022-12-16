package com.example.gruppajava.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gruppajava.entity.ParkingEvent;
import com.example.gruppajava.repository.CarRepository;
import com.example.gruppajava.repository.ParkingEventRepository;
import com.example.gruppajava.repository.UserRepository;


@RestController
@RequestMapping("/api/")
public class ParkingEventController {
    @Autowired ParkingEventRepository parkingEventRepository;
    @Autowired CarRepository carRepository;
    @Autowired UserRepository userRepository;

    // Get all parking events.
    @GetMapping("parkingevents")
    public Iterable<ParkingEvent> getAllParkingEvents() {
        return parkingEventRepository.findAll();
    }

    // Create a new parking event.
    @PostMapping("parkingevents")
    public ParkingEvent addParkingEvent(@RequestBody Map<String, String> body) {
        Long userId = Long.parseLong(body.get("userId"));
        Long carId = Long.parseLong(body.get("carId"));
        int parkingslotId = Integer.parseInt(body.get("parkingslotId"));

        ParkingEvent parkingEvent = new ParkingEvent();
        parkingEvent.setUser(userRepository.findById(userId).get());
        parkingEvent.setCar(carRepository.findById(carId).get());
        parkingEvent.setSlotId(parkingslotId);
        parkingEvent.setStartTime(LocalDateTime.now());
        parkingEvent.setEndTime(LocalDateTime.now().plusMinutes(10));
        parkingEvent.setActive(true);
        parkingEvent.setPaid(false);
        
        return parkingEventRepository.save(parkingEvent);
    }

    // Get parking event by id.
    @GetMapping("parkingevents/{id}")
    public ParkingEvent getParkingEventById(@PathVariable Long id) {
        return parkingEventRepository.findById(id).get();
    }

    // Get parking event by user id.
    @GetMapping("parkingevents/user/{id}")
    public Iterable<ParkingEvent> getParkingEventByUserId(@PathVariable Long id) {
        return parkingEventRepository.findByUserId(id);
    }

    // Get parking event by car id.
    @GetMapping("parkingevents/car/{id}")
    public Iterable<ParkingEvent> getParkingEventByCarId(@PathVariable Long id) {
        return parkingEventRepository.findByCarId(id);
    }

    // Need more patch routes for updating parking events later...

}
