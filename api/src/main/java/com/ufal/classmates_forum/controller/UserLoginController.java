package com.ufal.classmates_forum.controller;

import com.ufal.classmates_forum.UserLogin;
import com.ufal.classmates_forum.domain.User;
import com.ufal.classmates_forum.exceptions.UserAlreadyLoggedException;
import com.ufal.classmates_forum.exceptions.UserNotLoggedException;
import com.ufal.classmates_forum.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/login/{uid}")
    public ResponseEntity<?> login(@PathVariable String uid){
        try{
            if(existsByUID(uid)){
                UserLogin.getInstance().addUseUID(uid);
            } else{
                return new ResponseEntity<>(
                    String.format("User not found!"),
                    HttpStatus.NOT_FOUND  
                );
            }
        } catch(UserAlreadyLoggedException e){
            return new ResponseEntity<>(
              e.getMessage(),
              HttpStatus.NOT_ACCEPTABLE  
            );
        }
        
        return new ResponseEntity<>(
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/logout/{uid}")
    public ResponseEntity<?> logout(@PathVariable String uid){
        try{
            UserLogin.getInstance().removeUseUID(uid);
            
            return new ResponseEntity<>(
                HttpStatus.OK
            );
        } catch(UserNotLoggedException e){
            return new ResponseEntity<>(
                e.getMessage(),
                HttpStatus.NOT_FOUND
            );
        }
    } 

    public boolean existsByUID(String uid){
        for(User user: userRepository.findAll()){
            if(user.getUID().equals(uid)) return true;
        }
        return false;
    }

}