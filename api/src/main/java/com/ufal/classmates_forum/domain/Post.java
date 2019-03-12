package com.ufal.classmates_forum.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String content;

    @JsonBackReference(value="user_post")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonBackReference(value="topic_post")
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "comments")
    private List<User> userComments;

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

    public List<User> getUserComments() {
        return userComments;
    }

    public void setUserComments(List<User> userComments) {
        this.userComments = userComments;
    }
}
