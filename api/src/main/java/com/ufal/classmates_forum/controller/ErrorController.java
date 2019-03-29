package com.ufal.classmates_forum.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @GetMapping(value="/error/{msg}")
    public ResponseEntity<?> nonUserLogged(@PathVariable String msg){
        return new ResponseEntity<>(
            msg,
            HttpStatus.OK
        );
    }

    @GetMapping(value="/error/admin/{msg}")
    public ResponseEntity<?> userNotAdmin(@PathVariable String msg){
        return new ResponseEntity<>(
            msg,
            HttpStatus.OK
        );
    }

}