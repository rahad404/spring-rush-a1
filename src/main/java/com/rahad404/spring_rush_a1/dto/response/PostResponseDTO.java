package com.rahad404.spring_rush_a1.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostResponseDTO {
   private Long id;
   private String authorName;
   private String content;
   private LocalDateTime createdAt;
}
