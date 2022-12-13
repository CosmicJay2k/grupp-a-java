package com.example.gruppajava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gruppajava.entity.ParkingEvent;
import com.example.gruppajava.repository.ParkingEventRepository;

@RestController
@RequestMapping("/api/parkingevent")
public class ParkingEventController {
    @Autowired ParkingEventRepository parkingEventRepository;

    @GetMapping("/{id}")
    public ParkingEvent getParkingEventById(@PathVariable Long id) {
        return parkingEventRepository.findById(id).get();

        // Continue with more routes...........
    }
    
}
