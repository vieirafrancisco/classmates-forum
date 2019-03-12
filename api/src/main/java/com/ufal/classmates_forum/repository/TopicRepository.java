package com.ufal.classmates_forum.repository;

import com.ufal.classmates_forum.domain.Topic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
    
}