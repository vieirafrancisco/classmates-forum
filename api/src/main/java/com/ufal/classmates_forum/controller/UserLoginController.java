package com.ufal.classmates_forum.controller;

import com.ufal.classmates_forum.UserLogin;
import com.ufal.classmates_forum.domain.Login;
import com.ufal.classmates_forum.domain.User;
import com.ufal.classmates_forum.exceptions.UserAlreadyLoggedException;
import com.ufal.classmates_forum.exceptions.UserNotLoggedException;
import com.ufal.classmates_forum.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody Login login){
        String uid = login.getUID();
        
        try{
            if(existsByUid(uid)){
                UserLogin.getInstance().addUserUid(uid);
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

    @PostMapping(value = "/logout")
    public ResponseEntity<?> logout(@RequestBody Login login){
        String uid = login.getUID();
        
        if(existsByUid(uid)){
            try{
                UserLogin.getInstance().removeUserUid(uid);
                
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

        return new ResponseEntity<>(
            String.format("User don't exist"),
            HttpStatus.NOT_FOUND
        );
    } 

    private boolean existsByUid(String uid){
        for(User user: userRepository.findAll()){
            if(user.getUid().equals(uid)){
                return true;
            }
        }

        return false;
    }

}