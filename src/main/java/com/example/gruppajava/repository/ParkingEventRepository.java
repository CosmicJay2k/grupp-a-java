package com.example.gruppajava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gruppajava.entity.ParkingEvent;

public interface ParkingEventRepository extends JpaRepository<ParkingEvent, Long> {
    
}
