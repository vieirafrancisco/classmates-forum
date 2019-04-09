package com.ufal.classmates_forum.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String content;

    @JsonBackReference("user_post")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonBackReference("topic_post")
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @JsonManagedReference("post_comment")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="post")
    private List<Comment> comments;

    public Post(){}

    public Post(String name, String content){
        this.name = name;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<Comment> getComments(){
        return this.comments;
    }

    public void setComments(List<Comment> comments){
        this.comments = comments;
    }
}
