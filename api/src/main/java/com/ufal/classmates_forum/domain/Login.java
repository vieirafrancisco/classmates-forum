package com.ufal.classmates_forum.domain;

public class Login {

    private String UID;

    public Login(int id, String UID){
        this.UID = UID;
    }

    public String getUID(){
        return this.UID;
    }

    public void setUID(String UID){
        this.UID = UID;
    }

}