package com.ufal.classmates_forum.testsControllers;

import com.ufal.classmates_forum.DefaultControllerTest;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class ErrorControllerTests extends DefaultControllerTest {

    @Test
    public void nonUserLoggedTest(){
        HttpEntity<String> entity = new HttpEntity<>(
                "{}",headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/error/test"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }

    @Test
    public void userNotAdminTest(){
        HttpEntity<String> entity = new HttpEntity<>(
                "{}",headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/error/admin/test"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }
}
