package com.rahad404.spring_rush_a1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahad404.spring_rush_a1.dto.request.PostRequestDTO;
import com.rahad404.spring_rush_a1.dto.response.PostResponseDTO;
import com.rahad404.spring_rush_a1.service.PostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequestMapping("/posts")
@RestController
@RequiredArgsConstructor
public class PostController {
   @Autowired
   private PostService postService;
   
   @PostMapping
   public ResponseEntity<PostResponseDTO> createPost(@Valid @RequestBody PostRequestDTO request){
      PostResponseDTO response = postService.createPost(request);
      return ResponseEntity.ok(response);
   }
   
   // get all post
   @GetMapping
   public ResponseEntity<List<PostResponseDTO>> getAllPost() {
       return ResponseEntity.ok(postService.getAllActivePosts());
   }

   // delete
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deletePost(@PathVariable Long id) {
      postService.deletePost(id);
      return ResponseEntity.noContent().build();
   }   
}
