package com.ufal.classmates_forum;

import java.util.List;
import java.util.Vector;

import com.ufal.classmates_forum.exceptions.UserAlreadyLoggedException;
import com.ufal.classmates_forum.exceptions.UserNotLoggedException;;

public class UserLogin {
    
    private static UserLogin instance;
    private List<String> loggedUsers;

    private UserLogin(){
        loggedUsers = new Vector<>();
    }

    public static UserLogin getInstance(){
        if(instance == null){
            instance = new UserLogin();
        }
        return instance;
    }

    public boolean existByUid(String nuid){
        for(int i = 0; i < loggedUsers.size(); i++){
            if(loggedUsers.get(i).equals(nuid)) return true;
        }
        return false;
    }

    public void addUserUid(String uid) throws UserAlreadyLoggedException {
        if(!existByUid(uid)){
            loggedUsers.add(uid);
        } else {
            throw new UserAlreadyLoggedException(
                String.format("User already logged!")
            );
        }
    }

    public void removeUserUid(String uid) throws UserNotLoggedException {
        if(existByUid(uid)){
            loggedUsers.remove(uid);
        } else{
            throw new UserNotLoggedException(
                String.format("User not logged!")
            );
        }
    }

}