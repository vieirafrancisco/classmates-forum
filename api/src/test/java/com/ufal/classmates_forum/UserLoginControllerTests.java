package com.ufal.classmates_forum;


import com.ufal.classmates_forum.domain.Login;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class UserLoginControllerTests extends DefaultControllerTest{

    //Login Test
    @Test
    public void testLoginLogout(){
        //Login
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"uid\":\"abc\"}",headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/login"), HttpMethod.POST,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
        //Logout
        response = restTemplate.exchange(
                createURLWithPort("/logout"), HttpMethod.POST,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }

}
