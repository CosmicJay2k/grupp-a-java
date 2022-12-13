package com.example.gruppajava.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.gruppajava.entity.User;

public interface UserRepository extends ListCrudRepository<User, Long> {

}
