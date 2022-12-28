package com.example.gruppajava.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public ResponseEntity<ParkingEvent> addParkingEvent(@RequestBody Map<String, String> body) {
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
        parkingEventRepository.save(parkingEvent);
        
        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(parkingEvent.getId())
        .toUri();

        return ResponseEntity.created(location).body(parkingEvent);
    }

    // Get parking event by id.
    @GetMapping("parkingevents/{id}")
    public ParkingEvent getParkingEventById(@PathVariable Long id) {
        return parkingEventRepository.findById(id).get();
    }

    // Patch parking event by id. Adds x minutes to the parking event. example: (/api/parkingevents/{ID}?eventDurationMin={MINUTES})
    @PatchMapping("parkingevents/{id}")
    public ResponseEntity<ParkingEvent> patchParkingEventById(@PathVariable Long id, @RequestParam("eventDurationMin") int eventDurationMin) {
    ParkingEvent parkingEvent = parkingEventRepository.findById(id).get();
    parkingEvent.setEndTime(parkingEvent.getEndTime().plusMinutes(eventDurationMin));

    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .queryParam("eventDurationMin", eventDurationMin)
        .buildAndExpand(parkingEvent.getId())
        .toUri();
        return ResponseEntity.created(location).body(parkingEvent);
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