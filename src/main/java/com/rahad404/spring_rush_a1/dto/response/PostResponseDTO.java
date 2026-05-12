package com.rahad404.spring_rush_a1.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PostResponseDTO {
   private Long id;
   private String authorName;
   private String content;
   private LocalDateTime createdAt;
}
