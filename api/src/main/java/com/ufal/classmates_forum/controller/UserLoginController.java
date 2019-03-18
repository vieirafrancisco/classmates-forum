package com.ufal.classmates_forum.controller;

import com.ufal.classmates_forum.domain.UserLogin;
import com.ufal.classmates_forum.exceptions.UserNotLoggedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {

    @PostMapping(value = "/login/{uid}")
    public static ResponseEntity<?> login(@PathVariable String uid){
        UserLogin.getInstance().addUseUID(uid);
        
        return new ResponseEntity<>(
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/logout/{uid}")
    public static ResponseEntity<?> logout(@PathVariable String uid){
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

}