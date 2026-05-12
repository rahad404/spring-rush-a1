package com.rahad404.spring_rush_a1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahad404.spring_rush_a1.entity.User;

public interface UserRepository extends JpaRepository<User, Long> { 
   boolean existsByEmail(String email);
}
