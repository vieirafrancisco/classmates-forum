package com.ufal.classmates_forum;

import org.junit.Test;
import org.springframework.http.*;

public class UserControllerTests extends DefaultControllerTest {

    //Create User Test
    @Test
    public void testCreateUser() throws Exception{
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"uid\":100,\"name\":\"jadson\"}",headers);
        String response = restTemplate.postForObject(createURLWithPort("/user"),entity,String.class);
        System.out.println(response);
    }

    //Get all users test
    @Test
    public void testGetUser() throws Exception{
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user/1"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }

    //Get a user test
    @Test
    public void testGetUsers() throws Exception{
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/users"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }

    //Delete a user test
    @Test
    public void testDeleteUser() throws Exception{
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user/1"), HttpMethod.DELETE,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }

    /*Route not implemented
    @Test
    public void testUpdateUser() throws Exception{
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"uid\":abc,\"name\":\"Francisquinho\"}",headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user/2"), HttpMethod.PUT,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }*/
}
