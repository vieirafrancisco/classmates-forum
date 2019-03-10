package com.ufal.classmates_forum.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Inheritance
@DiscriminatorColumn(name = "user_type")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private ArrayList<Post> posts;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.PERSIST
            })
    @JoinTable(name = "user_comments",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "post_id")})
    private ArrayList<Post> comments;

    //Construtor padrão do framework
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

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Post> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Post> comments) {
        this.comments = comments;
    }
}
