package com.ufal.classmates_forum.repository;

import com.ufal.classmates_forum.domain.Tag;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    
}