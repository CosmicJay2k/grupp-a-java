package com.example.gruppajava.Service;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.gruppajava.entity.ParkingEvent;
import com.example.gruppajava.repository.CarRepository;
import com.example.gruppajava.repository.ParkingEventRepository;
import com.example.gruppajava.repository.UserRepository;

@Service
public class ParkingEventServiceImpl implements ParkingEventService {
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final ParkingEventRepository parkingEventRepository;

    public ParkingEventServiceImpl(
        UserRepository userRepository,
        CarRepository carRepository,
        ParkingEventRepository parkingEventRepository
    ) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.parkingEventRepository = parkingEventRepository;
    }

    @Override
    public ParkingEvent addParkingEvent(Map<String, String> body) {
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
        return parkingEvent;
    }
}
