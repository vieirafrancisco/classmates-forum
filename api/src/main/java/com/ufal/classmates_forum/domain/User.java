package com.ufal.classmates_forum.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
@Inheritance
@DiscriminatorColumn(name = "user_type")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @JsonManagedReference("user_topic")
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "author")
    private List<Topic> topics;

    @Column(unique=true)
    private String UID;

    @JsonManagedReference("user_post")
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Post> posts;

    public User(){}

    public User(String name){
        this.name = name;
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getUID(){
        return this.UID;
    }

    public void setUID(String UID){
        this.UID = UID;
    }

    public List<Topic> getTopics(){
        return this.topics;
    }

    public void setTopics(List<Topic> topics){
        this.topics = topics;
    }

}
