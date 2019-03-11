package com.ufal.classmates_forum.repository;

import com.ufal.classmates_forum.domain.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
    
}