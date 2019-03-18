package com.ufal.classmates_forum.domain;

import java.util.Set;

import com.ufal.classmates_forum.exceptions.UserNotLoggedException;;

public class UserLogin {
    
    private static UserLogin instance;
    private Set<String> loggedUsers;

    private UserLogin(){}

    public static UserLogin getInstance(){
        if(instance == null){
            instance = new UserLogin();
        }
        return instance;
    }

    public boolean existByUID(String nuid){
        for(String uid: loggedUsers){
            if(uid.equals(nuid)) return true;
        }
        return false;
    }

    public void addUseUID(String uid){
        if(!existByUID(uid)){
            loggedUsers.add(uid);
        } 
    }

    public void removeUseUID(String uid) throws UserNotLoggedException {
        if(existByUID(uid)){
            loggedUsers.remove(uid);
        } else{
            throw new UserNotLoggedException(
                String.format("User not logged! uid: %d", uid)
            );
        }
    }

}