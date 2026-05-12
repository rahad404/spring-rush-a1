package com.rahad404.spring_rush_a1.dto.response;

import lombok.Data;

@Data
public class UserResponseDTO {
   private Long id;
   private String fullname;
   private String email;
   private String bio;
}
