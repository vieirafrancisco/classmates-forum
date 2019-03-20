package com.ufal.classmates_forum.repository;

import com.ufal.classmates_forum.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

}