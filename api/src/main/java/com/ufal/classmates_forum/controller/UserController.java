package com.ufal.classmates_forum.controller;

import java.util.Optional;

import com.ufal.classmates_forum.domain.User;
import com.ufal.classmates_forum.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    
    @Autowired
    private UserRepository repository;

    @GetMapping(value="/users")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(
            repository.findAll(),
            HttpStatus.OK
        ); 
    }

    @GetMapping(value="/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id){

        if(repository.existsById(id)){
            Optional<User> user = repository.findById(id);
            
            return new ResponseEntity<>(
                user.get(), 
                HttpStatus.OK
            );
        }

        // User not found
        return new ResponseEntity<>(
            String.format("User with id: %d not found!", id),
            HttpStatus.NOT_FOUND
        );
    }

    // Create user if user don't already exist in repository
    @PostMapping(value="/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {

        String userType = user.getUserType();
        
        if(userType == null || !(userType.equals("user") || userType.equals("admin"))){
            user.setUserType("user");
        }

        if(repository.existsByUid(user.getUid())){
            return new ResponseEntity<>(
                String.format("User with this uid already exist!"),
                HttpStatus.NOT_ACCEPTABLE
            );
        }

        if(repository.existsById(user.getId())){
            return new ResponseEntity<>(
                String.format("User with this id already exist!"),
                HttpStatus.NOT_ACCEPTABLE
            );
        }
        
        repository.save(user);

        return new ResponseEntity<>(
            String.format("User %s created succefuly!", user.getName()), 
            HttpStatus.CREATED
        );
    }

    @DeleteMapping(value="/user")
    public ResponseEntity<?> removerUser(@RequestAttribute User user) {
        repository.delete(user);

        return new ResponseEntity<>(
            user.getId(),
            HttpStatus.OK
        );
    }

}