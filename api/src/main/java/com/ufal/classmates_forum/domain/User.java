package com.ufal.classmates_forum.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;

    private String userType;

    @Column(unique=true)
    private String email;

    private String imageUrl;

    @Column(unique=true)
    private String uid;

    @JsonManagedReference("user_topic")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "author")
    private List<Topic> topics;

    @JsonManagedReference("user_post")
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Post> posts;

    @JsonManagedReference("user_comment")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="user")
    private List<Comment> comments;

    public User(){}

    public User(String uid, String name){
        this.uid = uid;
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

    public String getUid(){
        return this.uid;
    }

    public void setUid(String uid){
        this.uid = uid;
    }

    public String getUserType(){
        return this.userType;
    }

    public void setUserType(String userType){
        this.userType = userType;
    }

    public List<Topic> getTopics(){
        return this.topics;
    }

    public void setTopics(List<Topic> topics){
        this.topics = topics;
    }

    public List<Comment> getComments(){
        return this.comments;
    }

    public void setComments(List<Comment> comments){
        this.comments = comments;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getImageUrl(){
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    @PreRemove
    public void userPreRemove(){
        for(Post post: this.posts){
            post.setUser(null);
        }
    }

}
