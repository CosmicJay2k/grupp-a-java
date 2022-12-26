package com.example.gruppajava.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

  
}
