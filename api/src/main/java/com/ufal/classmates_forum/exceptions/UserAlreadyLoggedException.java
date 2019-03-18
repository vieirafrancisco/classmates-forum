package com.ufal.classmates_forum.exceptions;

public class UserAlreadyLoggedException extends Exception {

    private static final long serialVersionUID = 1L;

    public UserAlreadyLoggedException() {
    }

    public UserAlreadyLoggedException(String msg){
        super(msg);
    }

}