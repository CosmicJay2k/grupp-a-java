package com.example.gruppajava.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gruppajava.entity.ParkingEvent;
import com.example.gruppajava.repository.ParkingEventRepository;

@RestController
@RequestMapping("/api/parkingevent")
public class ParkingEventController {
    @Autowired ParkingEventRepository parkingEventRepository;

    // Get all parking events.
    @GetMapping("/")
    public Iterable<ParkingEvent> getAllParkingEvents() {
        return parkingEventRepository.findAll();
    }
    
    // Add a new parking event.
    @PostMapping("/")
    public ParkingEvent addParkingEvent(@RequestBody ParkingEvent parkingEvent) {
        parkingEvent.setStartTime(LocalDateTime.now());
        parkingEvent.setEndTime(LocalDateTime.now().plusMinutes(10));
        parkingEvent.setActive(true);
        parkingEvent.setPaid(false);
        return parkingEventRepository.save(parkingEvent);
    }

    // Get parking event by id.
    @GetMapping("/{id}")
    public ParkingEvent getParkingEventById(@PathVariable Long id) {
        return parkingEventRepository.findById(id).get();
    }

    // Get parking event by user id.
    @GetMapping("/user/{id}")
    public Iterable<ParkingEvent> getParkingEventByUserId(@PathVariable Long id) {
        return parkingEventRepository.findByUserId(id);
    }

    // Get parking event by car id.
    @GetMapping("/car/{id}")
    public Iterable<ParkingEvent> getParkingEventByCarId(@PathVariable int id) {
        return parkingEventRepository.findByCarId(id);
    }

}
