package com.rahad404.spring_rush_a1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahad404.spring_rush_a1.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
   List<Post> findAllByActiveTrue();
}
