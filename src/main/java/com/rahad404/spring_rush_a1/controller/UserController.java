package com.rahad404.spring_rush_a1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahad404.spring_rush_a1.dto.request.UserRequestDTO;
import com.rahad404.spring_rush_a1.dto.response.UserResponseDTO;
import com.rahad404.spring_rush_a1.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
   @Autowired
   private UserService userService;

   @PostMapping
   public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO request){
       UserResponseDTO response = userService.createUser(request);
       return ResponseEntity.ok(response);
   }

   @GetMapping("/{id}")
   public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id){
      UserResponseDTO response = userService.getUserById(id);
      return ResponseEntity.ok(response);
   }

   @PutMapping("/{id}")
   public ResponseEntity<UserResponseDTO> updateBio(@PathVariable Long id, @RequestBody UserRequestDTO request) {
       return ResponseEntity.ok(userService.updateBio(id, request));
   }
}
