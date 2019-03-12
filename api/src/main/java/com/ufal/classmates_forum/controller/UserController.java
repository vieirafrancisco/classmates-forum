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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class UserController {
    
    @Autowired
    private UserRepository repository;

    @GetMapping(value="/users")
    public ResponseEntity<?> getAllUsers(){

        if(repository.count() != 0){

            return new ResponseEntity<>(
                repository.findAll(),
                HttpStatus.OK
            );         

        }

        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT
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
    @ResponseBody
    public ResponseEntity<?> createUser(@RequestBody User user) {
        
        if(repository.existsById(user.getId())){
            return new ResponseEntity<>(
                String.format("User with id: %d already exist!", user.getId()),
                HttpStatus.NOT_ACCEPTABLE
            );
        }
        
        repository.save(user);

        return new ResponseEntity<>(
            String.format("User %s created succefuly!", user.getName()), 
            HttpStatus.CREATED
            );
    }

    @DeleteMapping(value="/user/{id}")
    public ResponseEntity<?> removerUser(@PathVariable Integer id){

        // User exist in repository
        if(repository.existsById(id)){
            Optional<User> user = repository.findById(id);
            repository.deleteById(id);

            return new ResponseEntity<>(
                user.get().getId(),
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(
            "User doesn't found",
            HttpStatus.NOT_FOUND
        );

    }
    

}