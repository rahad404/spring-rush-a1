package com.rahad404.spring_rush_a1.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahad404.spring_rush_a1.dto.request.PostRequestDTO;
import com.rahad404.spring_rush_a1.dto.response.PostResponseDTO;
import com.rahad404.spring_rush_a1.entity.Post;
import com.rahad404.spring_rush_a1.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
   @Autowired
   private PostRepository postRepository;

   // create post 
   public PostResponseDTO createPost(PostRequestDTO request){
      Post post = Post.builder()
         .authorName(request.getAuthorName())
         .content(request.getContent())
         .createdAt(LocalDateTime.now())
         .build();
      
      Post savedPost = postRepository.save(post);
      return mapToResponseDTO(savedPost);
   }

   // all post
   public List<PostResponseDTO> getAllActivePosts(){
      List<Post> posts = postRepository.findAllByActiveTrue();
      return posts.stream()
         .map(this::mapToResponseDTO)
         .toList();
   }

   // delete post
   public void deletePost(Long id){
      Post post = postRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
      
      post.setActive(false);
      postRepository.save(post);
   }

   // mapper
   private PostResponseDTO mapToResponseDTO(Post post){
      return PostResponseDTO.builder()
         .id(post.getId())
         .authorName(post.getAuthorName())
         .content(post.getContent())
         .createdAt(post.getCreatedAt())
         .build();
   }
}
