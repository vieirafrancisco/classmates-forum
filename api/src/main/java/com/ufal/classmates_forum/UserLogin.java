package com.ufal.classmates_forum;

import java.util.Hashtable;

import com.ufal.classmates_forum.domain.User;
import com.ufal.classmates_forum.exceptions.UserAlreadyLoggedException;
import com.ufal.classmates_forum.exceptions.UserNotLoggedException;;

public class UserLogin {
    
    private static UserLogin instance;
    private Hashtable<String, User> loggedUsers;

    private UserLogin(){
        loggedUsers = new Hashtable<>();
    }

    public static UserLogin getInstance(){
        if(instance == null){
            instance = new UserLogin();
        }
        return instance;
    }

    public boolean existByUid(String uid){
        return (uid != null) ? loggedUsers.containsKey(uid):false;
    }

    public void addLoggedUser(User user) throws UserAlreadyLoggedException {
        String uid = user.getUid();
        if(!existByUid(uid)){
            loggedUsers.put(uid, user);
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

    public String getUserTypeByUid(String uid){
        return loggedUsers.get(uid).getUserType();
    }

    public User getUserByUid(String uid){
        return loggedUsers.get(uid);
    }

}