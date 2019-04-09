package com.ufal.classmates_forum.controller;

import java.util.List;
import java.util.Optional;

import com.ufal.classmates_forum.domain.Comment;
import com.ufal.classmates_forum.domain.User;
import com.ufal.classmates_forum.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentRepository repository;

    @GetMapping(value = "/comments")
    public ResponseEntity<List<Comment>> getAllComments() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "comment/{id}")
    public ResponseEntity<?> getCommentById(@PathVariable Integer id) {

        if (repository.existsById(id)) {
            Optional<Comment> comment = repository.findById(id);

            return new ResponseEntity<>(comment.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(String.format("comment with id: %d doesn't exist", id), HttpStatus.NOT_FOUND);

    }

    @PostMapping(value = "/comment")
    public ResponseEntity<?> createComment(@RequestBody Comment comment) {

        if (repository.existsById(comment.getId())) {
            return new ResponseEntity<>(String.format("comment with id: %d already exist!", comment.getId()),
                    HttpStatus.NOT_ACCEPTABLE);
        }

        repository.save(comment);

        return new ResponseEntity<>(String.format("comment created succefuly!"), HttpStatus.CREATED);

    }

    @DeleteMapping(value = "/comment/{id}")
    public ResponseEntity<?> removeComment(@PathVariable int id, @RequestAttribute User user) {

        if(repository.existsById(id)){
            Comment comment = repository.getOne(id);

            if(comment.getUser().getId() != user.getId()){
                return new ResponseEntity<>(
                    "Can't remove this comment, you not allowed!",
                    HttpStatus.NOT_ACCEPTABLE
                );
            }

            repository.delete(comment);

            return new ResponseEntity<>(
                comment.getId(),
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(
            String.format("this comment doesn't exist"),
            HttpStatus.NOT_FOUND
        );
    }

}