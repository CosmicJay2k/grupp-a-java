package com.example.gruppajava.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ParkingEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    // Fix when car entity exists.
    // @OneToOne
    // @JoinColumn(name = "car_id", referencedColumnName = "id")
    // private Car car;
    private int carId;
    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;
    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;
    // Fix when parkingslot entity exists.
    // @OneToOne
    // @JoinColumn(name = "slot_id", referencedColumnName = "id")
    // private ParkingSlot parkingslot;
    private int slotId;
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @Column(name = "is_paid", nullable = false)
    private boolean isPaid;

    // Getters and setters.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Fix when car entity exists.
    public int getCarId() {
        return carId;
    }

    // Fix when car entity exists.
    public void setCarId(int carId) {
        this.carId = carId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    // Fix when slot entity exists.
    public int getSlotId() {
        return slotId;
    }

    // Fix when slot entity exists.
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    
    
}
