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
        routesAdmin.add("/user/[0-9]");
        routesAdmin.add("/topic");
    }

    public boolean preHandle(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler
    ) throws Exception {
        
        String uri = request.getRequestURI();
        String msg;
        
        if(routesAdmin.contains(uri) || matchesRegexRoute(uri)){
            String uid = request.getHeader("token");

            if(UserLogin.getInstance().existByUid(uid)){
                if(UserLogin.getInstance().getUserTypeByUid(uid).equals("admin")){
                    return true;
                } else{
                    msg = "User not Admin!";
                    response.sendRedirect("/error/admin/" + msg);
                }
            } else{
                msg = "Non user Logged!";
                response.sendRedirect("/error/" + msg);
            }
        }

        return true;
    }

    private boolean matchesRegexRoute(String uri){
        for(String route: routesAdmin){
            if(uri.matches(route)) return true;
        }
        return false;
    }

}