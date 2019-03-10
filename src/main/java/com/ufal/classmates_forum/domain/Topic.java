package com.ufal.classmates_forum.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Topic")
    private ArrayList<Post> posts;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {
                    CascadeType.PERSIST,
                    CascadeType.PERSIST
                })
    @JoinTable(name = "topic_tags",
                joinColumns = {@JoinColumn(name = "topic_id")},
                inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private ArrayList<Tag> tags;

    public Topic(){}

    public Topic(String description){
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }
}
