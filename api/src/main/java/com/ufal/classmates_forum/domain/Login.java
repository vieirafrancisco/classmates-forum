package com.ufal.classmates_forum.domain;

public class Login {

    private int id;
    private String UID;

    public Login(int id, String UID){
        this.id = id;
        this.UID = UID;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUID(){
        return this.UID;
    }

    public void setUID(String UID){
        this.UID = UID;
    }

}