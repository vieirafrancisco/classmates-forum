package com.ufal.classmates_forum;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ufal.classmates_forum.domain.User;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    private List<Pair> routesAdmin = new ArrayList<>();
    private List<Pair> routesUser = new ArrayList<>();

    public LoginInterceptor(){
        routesAdmin.add(new Pair("/users", "get"));
        routesAdmin.add(new Pair("/user/[0-9]", "get"));
        routesAdmin.add(new Pair("/topic", "post"));
        routesAdmin.add(new Pair("/topic/[0-9]", "delete"));

        routesUser.add(new Pair("/user", "delete"));
    }

    public boolean preHandle(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler
    ) throws Exception {
        
        String uri = request.getRequestURI();
        String method = request.getMethod();
        String msg;
        
        if(contains(uri, method, this.routesUser)){
            String uid = request.getHeader("token");
            if(UserLogin.getInstance().existByUid(uid)){
                User user = UserLogin.getInstance().getUserByUid(uid);
                request.setAttribute("user", user);
                
                return true;
            } else{
                msg = "Non user Logged!";
                response.sendRedirect("/error/" + msg);
                return false;
            }
        }
        
        if(contains(uri, method, this.routesAdmin)){
            String uid = request.getHeader("token");
            
            if(UserLogin.getInstance().existByUid(uid)){
                User user = UserLogin.getInstance().getUserByUid(uid);
                request.setAttribute("user", user);
                
                if(user.getUserType().equals("admin")){
                    return true;
                } else{
                    msg = "User not Admin!";
                    response.sendRedirect("/error/admin/" + msg);
                    return false;
                }
            } else{
                msg = "Non user Logged!";
                response.sendRedirect("/error/" + msg);
                return false;
            }
        }

        return true;
    }

    private boolean contains(String url, String method, List<Pair> routes){
        for(Pair p : routes){
            if(url.matches(p.getFirst()) && method.toLowerCase().equals(p.getSecond())) return true;
        }
        return false;
    }

}