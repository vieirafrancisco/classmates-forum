package com.ufal.classmates_forum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ufal.classmates_forum.domain.User;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    private List<ServicePermition> routes = new ArrayList<>();

    public LoginInterceptor(){
        routes.add(new ServicePermition("/users", "get", Arrays.asList("admin")));
        routes.add(new ServicePermition("/user/[0-9]", "get", Arrays.asList("admin")));
        routes.add(new ServicePermition("/topic", "post", Arrays.asList("admin")));
        routes.add(new ServicePermition("/topic/[0-9]", "delete", Arrays.asList("admin")));

        routes.add(new ServicePermition("/user", "delete", Arrays.asList("admin", "user")));
        routes.add(new ServicePermition("/comment/[0-9]", "delete", Arrays.asList("admin", "user")));
    }

    public boolean preHandle(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler
    ) throws Exception {
        
        String uri = request.getRequestURI();
        String method = request.getMethod();
        String msg;
        ServicePermition s = match(uri, method, routes);

        if(s != null){
            String uid = request.getHeader("token");

            if(UserLogin.getInstance().existByUid(uid)) {
                User user = UserLogin.getInstance().getUserByUid(uid);
                if(s.getAllowedUsersTypes().contains(user.getUserType())){
                    request.setAttribute("user", user);
                }else{
                    msg = "permission denied!";
                    response.sendRedirect("/error/" + msg);
                    return false;
                }
            }else{
                if(uid == null){
                    msg = "Token not passed to request";
                }else{
                    msg = "user not logged";
                }
                response.sendRedirect("/error/" + msg);
                return false;
            }

        }

        return true;
    }

    private ServicePermition match(String url, String method, List<ServicePermition> routes){
        for(ServicePermition p : routes){
            if(url.matches(p.getUri()) && method.toLowerCase().equals(p.getMethod())) return p;
        }
        return null;
    }

}