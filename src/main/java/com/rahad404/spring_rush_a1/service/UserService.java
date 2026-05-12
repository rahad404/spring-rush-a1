package com.rahad404.spring_rush_a1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;
import org.springframework.stereotype.Service;

import com.rahad404.spring_rush_a1.dto.request.UserRequestDTO;
import com.rahad404.spring_rush_a1.dto.response.UserResponseDTO;
import com.rahad404.spring_rush_a1.entity.User;
import com.rahad404.spring_rush_a1.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
   @Autowired
   private UserRepository userRepository;


   // create user
   public UserResponseDTO createUser(UserRequestDTO request){
      if(userRepository.existsByEmail(request.getEmail())){
         throw new RuntimeException("Email already exists: " + request.getEmail());
      }

      User user = User.builder()
         .fullname(request.getFullname())
         .email(request.getEmail())
         .bio(request.getBio())
         .build();
      User savedUser = userRepository.save(user);
      return mapToResponseDTO(savedUser);
   }

   // get user
   public UserResponseDTO getUserById(Long id){
      User user = userRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("User not found with id: " + id)); 
      return mapToResponseDTO(user);
   }

   // update bio
   public UserResponseDTO updateBio(Long id, UserRequestDTO request){
      User user = userRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
      
      user.setBio(request.getBio());
      User updatedUser = userRepository.save(user);
      return mapToResponseDTO(updatedUser);
   }

   // mapper
   private UserResponseDTO mapToResponseDTO(User user){
      return UserResponseDTO.builder()
         .id(user.getId())
         .fullname(user.getFullname())
         .email(user.getEmail())
         .bio(user.getBio())
         .build();
   }

   public UserRepository getUserRepository() {
      return userRepository;
   }

   public void setUserRepository(UserRepository userRepository) {
      this.userRepository = userRepository;
   }
}
