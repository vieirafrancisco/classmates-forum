package com.ufal.classmates_forum.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance
@DiscriminatorColumn(name = "user_type")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Column(unique=true)
    private String UID;

    @JsonBackReference(value="user_post")
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
}
