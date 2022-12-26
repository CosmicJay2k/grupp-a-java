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

import com.example.gruppajava.entity.ParkSlot;
import com.example.gruppajava.repository.ParkSlotRepository;

@RestController
public class ParkSlotController {
  
  private final ParkSlotRepository parkslotRepo;

  public ParkSlotController(ParkSlotRepository parkslotRepo){
    this.parkslotRepo=parkslotRepo;
  }

  // GET GET GET GET
  // return all park slots
  @GetMapping("/api/parkslot")
  public List<ParkSlot> getAllParkSlots(){
  return parkslotRepo.findAll();
  }

  // return one park slot depending on (id) parameter
  @GetMapping("/api/parkslot/{id}")
  public ParkSlot getParkSlot(@PathVariable Long id) {
    return parkslotRepo.findById(id).get();
  }

  // POST POST POST POST
  record addParkSlotReq(
    long zone_id, //ParkPriceZone zone,
    boolean available
  ){}

  // add a new park slot, (id) generated automatically
  @PostMapping("/api/parkslot")
  public ResponseEntity<ParkSlot> addParkSlot(@RequestBody addParkSlotReq req){
    ParkSlot parkslot = new ParkSlot(
      req.zone_id,
      req.available
    );

    parkslotRepo.save(parkslot);
    
    URI location=ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(parkslot.getId())
      .toUri();
    return ResponseEntity.created(location).body(parkslot);
  }
  
}
