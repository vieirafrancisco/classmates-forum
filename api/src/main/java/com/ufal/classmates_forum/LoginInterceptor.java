package com.ufal.classmates_forum;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final List<String> routesAdmin = new ArrayList<>();

    public LoginInterceptor(){
        routesAdmin.add("/users");
        routesAdmin.add("/user/{id}");
        routesAdmin.add("/topic");
    }

    public boolean preHandle(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler
    ) throws Exception {
        
        return true;
    }

}