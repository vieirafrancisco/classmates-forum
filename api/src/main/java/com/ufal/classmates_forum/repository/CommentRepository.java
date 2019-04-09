package com.ufal.classmates_forum.repository;

import com.ufal.classmates_forum.domain.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    
}