package com.rahad404.spring_rush_a1.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostRequestDTO {
   @NotBlank(message = "Author can't be empty")
   private String authorName;

   @NotBlank(message = "Conten can't be empty")
   @Size(max = 280, message = "Content can't be more than 280 characters")
   private String content;
}
