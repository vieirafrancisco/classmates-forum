package com.ufal.classmates_forum.controller;

import java.util.Optional;

import com.ufal.classmates_forum.domain.Tag;
import com.ufal.classmates_forum.repository.TagRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {

    @Autowired
    private TagRepository repository;

    @GetMapping(value="tag/{id}")
    public ResponseEntity<?> getTagById(@PathVariable Integer id){

        if(repository.existsById(id)){
            Optional<Tag> tag = repository.findById(id);

            return new ResponseEntity<>(
                tag.get(),
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(
            String.format("User with id: %d doesn't exist", id),
            HttpStatus.NOT_FOUND
        );

    }

    @PostMapping(value="/tag")
    public ResponseEntity<?> createTag(@RequestBody Tag tag){

        // If tag already exist
        if(repository.existsById(tag.getId())){
            return new ResponseEntity<>(
                String.format("Tag with id: %d already exist!", tag.getId()),
                HttpStatus.NOT_ACCEPTABLE
            );
        }

        repository.save(tag);

        return new ResponseEntity<>(
            String.format("Tag created succefuly!"),
            HttpStatus.CREATED
        );

    }

    @DeleteMapping(value="/tag/{id}")
    public ResponseEntity<?> removeTag(@PathVariable Integer id){

        if(repository.existsById(id)){
            Optional<Tag> tag = repository.findById(id);
            repository.deleteById(id);

            return new ResponseEntity<>(
                tag.get().getId(),
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(
            String.format("User with id: %d doesn't exist", id),
            HttpStatus.NOT_FOUND
        );
    }

} 