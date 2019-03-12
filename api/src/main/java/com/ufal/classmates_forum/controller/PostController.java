package com.ufal.classmates_forum.controller;

import java.util.Optional;

import com.ufal.classmates_forum.domain.Post;
import com.ufal.classmates_forum.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PostController {

    @Autowired
    private PostRepository repository;

    @GetMapping(value="/posts")
    public ResponseEntity<?> listAllPosts(){

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

    @GetMapping(value="/post/{id}")
    public ResponseEntity<?> getPostById(@PathVariable Integer id) {

        if(repository.existsById(id)){
            Optional<Post> post = repository.findById(id);

            return new ResponseEntity<>(
                post.get(),
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(
            "Post not found!",
            HttpStatus.NOT_FOUND
        );
    }

    @PostMapping(value="/post")
    public ResponseEntity<?> createPost(@RequestBody Post post) {

        // Post already exist
        if(repository.existsById(post.getId())){
            return new ResponseEntity<>(
                "Post already exist!",
                HttpStatus.NOT_ACCEPTABLE
            );
        }

        repository.save(post);

        return new ResponseEntity<>(
            String.format("Post %s created!", post.getName()),
            HttpStatus.CREATED
        );
    }

    @DeleteMapping(value="/post/{id}")
    public ResponseEntity<?> removePost(@PathVariable Integer id) {

        if(repository.existsById(id)){
            Optional<Post> post = repository.findById(id);
            repository.deleteById(id);

            return new ResponseEntity<>(
                post.get().getId(),
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(
            "Post doesn't found!",
            HttpStatus.NOT_FOUND
        );
    }

}