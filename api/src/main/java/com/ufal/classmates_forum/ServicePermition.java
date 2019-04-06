package com.ufal.classmates_forum;

import java.util.List;

public class ServicePermition {
    private String uri;
    private String method;
    private List<String> allowedUsersTypes;

    public ServicePermition(String uri, String method, List<String> allowedUsersTypes) {
        this.uri = uri;
        this.method = method;
        this.allowedUsersTypes = allowedUsersTypes;
    }

    public String getUri() {
        return uri;
    }

    public void setUrit(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<String> getAllowedUsersTypes() {
        return allowedUsersTypes;
    }

    public void setAllowedUsersTypes(List<String> allowedUsersTypes){
        this.allowedUsersTypes = allowedUsersTypes;
    }
}
