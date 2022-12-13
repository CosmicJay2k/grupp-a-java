package com.example.gruppajava.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    // @OneToMany(mappedBy = "owner")
    private List<String> cars = new ArrayList<>();
    // CHANGE TO List<Car> WHEN CAR ENTITY EXISTS

    protected User() {
    }

    public User(String firstName, String lastName, String cars) {
        // CHANGE TO Car cars WHEN CAR ENTITY EXISTS
        this.firstName = firstName;
        this.lastName = lastName;
        this.cars.add(cars);
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getCars() {
        return cars;
    }
    // CHANGE TO List<Car> WHEN CAR ENTITY EXISTS

    public void setCars(List<String> cars) {
        this.cars = cars;
    }
    // CHANGE TO List<Car> WHEN CAR ENTITY EXISTS
}
