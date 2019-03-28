package com.ufal.classmates_forum;

import java.util.Hashtable;

import com.ufal.classmates_forum.exceptions.UserAlreadyLoggedException;
import com.ufal.classmates_forum.exceptions.UserNotLoggedException;;

public class UserLogin {
    
    private static UserLogin instance;
    private Hashtable<String, String> loggedUsers;

    private UserLogin(){
        loggedUsers = new Hashtable<>();
    }

    public static UserLogin getInstance(){
        if(instance == null){
            instance = new UserLogin();
        }
        return instance;
    }

    public boolean existByUid(String nuid){
        for(String uid: loggedUsers.keySet()){
            if(uid.equals(nuid)) return true;
        }
        return false;
    }

    public void addLoggedUser(String uid, String userType) throws UserAlreadyLoggedException {
        if(!existByUid(uid)){
            loggedUsers.put(uid, userType);
        } else {
            throw new UserAlreadyLoggedException(
                String.format("User already logged!")
            );
        }
    }

    public void removeLoggedUser(String uid) throws UserNotLoggedException {
        if(existByUid(uid)){
            loggedUsers.remove(uid);
        } else{
            throw new UserNotLoggedException(
                String.format("User not logged!")
            );
        }
    }

}