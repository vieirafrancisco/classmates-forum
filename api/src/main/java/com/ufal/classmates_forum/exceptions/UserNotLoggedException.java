package com.ufal.classmates_forum.exceptions;

public class UserNotLoggedException extends Exception {

    private static final long serialVersionUID = 1L;

    public UserNotLoggedException() {}

    public UserNotLoggedException(String msg){
        super(msg);
    }

}