package com.rahad404.spring_rush_a1.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDTO {
   @NotBlank(message = "must enter fullname")
   private String fullname;

   @NotBlank(message = "must enter email")
   @Email(message = "must add a valid email")
   private String email;

   private String bio;
}
