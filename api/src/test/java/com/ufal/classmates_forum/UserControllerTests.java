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
        assert response.contains("created");
    }

    //User Already Exists Test
    @Test
    public void testUserAlreadyCreated() throws Exception{
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"id\":1,\"uid\":100,\"name\":\"jadson\"}",headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user"), HttpMethod.POST,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 406;
    }

    //User Not Found test
    @Test
    public void testUserNotFound() throws Exception{
        UserLogin.getInstance().addLoggedUser("abcd","admin");
        headers.add("token","abcd");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user/5"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        UserLogin.getInstance().removeLoggedUser("abcd");
        assert response.getStatusCodeValue() == 404;

    }

    //Get a user test
    @Test
    public void testGetUser() throws Exception{
        UserLogin.getInstance().addLoggedUser("abcd","admin");
        headers.add("token","abcd");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user/1"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        UserLogin.getInstance().removeLoggedUser("abcd");
        assert response.getStatusCodeValue() == 200;

    }

    //Get all users test
    @Test
    public void testGetAllUsers() throws Exception{
        UserLogin.getInstance().addLoggedUser("abcd","admin");
        headers.add("token","abcd");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/users"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        UserLogin.getInstance().removeLoggedUser("abcd");
        assert response.getStatusCodeValue() == 200;
    }

    //Delete a user test
    @Test
    public void testDeleteUser() throws Exception{
        UserLogin.getInstance().addLoggedUser("abcd","admin");
        headers.add("token","abcd");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user/1"), HttpMethod.DELETE,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        UserLogin.getInstance().removeLoggedUser("abcd");
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
