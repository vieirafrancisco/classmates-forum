package com.ufal.classmates_forum.controller;

import java.util.Optional;

import com.ufal.classmates_forum.domain.Topic;
import com.ufal.classmates_forum.repository.TopicRepository;

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
public class TopicController {

    @Autowired
    private TopicRepository repository;

    @GetMapping(value="/topics")
    public ResponseEntity<?> listAllTopics(){

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

    @GetMapping(value="/topic/{id}")
    public ResponseEntity<?> getTopicById(@PathVariable Integer id){

        if(repository.existsById(id)){
            Optional<Topic> topic = repository.findById(id);

            return new ResponseEntity<>(
                topic.get(),
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(
            String.format("Topic with id: %d doesn't exist!", id),
            HttpStatus.NOT_FOUND
        );
    }

    @PostMapping(value="/topic")
    public ResponseEntity<?> createTopic(@RequestBody Topic topic){

        if(repository.existsById(topic.getId())){
            return new ResponseEntity<>(
                String.format("Topic with id: %d already exist!", topic.getId()),
                HttpStatus.NOT_ACCEPTABLE
            );
        }

        repository.save(topic);

        return new ResponseEntity<>(
            String.format("Topic create successfully!"),
            HttpStatus.OK
        );
    }

    @DeleteMapping(value="/topic/{id}")
    public ResponseEntity<?> removeTopic(@PathVariable Integer id){

        if(repository.existsById(id)){
            Optional<Topic> topic = repository.findById(id);
            repository.deleteById(id);

            return new ResponseEntity<>(
                topic.get().getId(),
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(
            String.format("Topic with id: %d doesn't exist!", id),
            HttpStatus.NOT_FOUND
        );
    }

} 