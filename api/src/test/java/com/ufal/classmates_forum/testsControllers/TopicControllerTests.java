package com.ufal.classmates_forum.testsControllers;

import com.ufal.classmates_forum.DefaultControllerTest;
import com.ufal.classmates_forum.UserLogin;
import com.ufal.classmates_forum.domain.User;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class TopicControllerTests extends DefaultControllerTest {

    //Create Topic test
    @Test
    public void testCreateTopic() throws Exception{

        User user = new User("abcd","Francisco");
        user.setUserType("admin");
        user.setId(2);
        UserLogin.getInstance().addLoggedUser(user);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("token","abcd");
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"description\":\"jadson\"}",headers);
        //String response = restTemplate.postForObject(createURLWithPort("/topic"),entity,String.class);
        //System.out.println(response);
        //UserLogin.getInstance().removeLoggedUser("123");
        //assert response.contains("create");
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/topic"),HttpMethod.POST,entity,String.class);
        System.out.println(response);
        UserLogin.getInstance().removeLoggedUser("abcd");
        assert response.getStatusCodeValue() == 200;
    }
    //Get All Topics test
    @Test
    public void testGetAllTopics() throws Exception {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/topics"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }
    //Get Topic test
    @Test
    public void testGetTopic(){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/topic/1"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }
    //Delete topic test
    @Test
    public void testDeleteTopic(){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/topic/2"), HttpMethod.DELETE,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }
    //Topic Not Found Test
    @Test
    public void testTopicNotFound(){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/topic/134"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 404;
    }
    //Topic Id Already Existis
    @Test
    public void testTopicIdAlreadyExists() throws Exception{
        User user = new User("abcd","Francisco");
        user.setUserType("admin");
        user.setId(2);
        UserLogin.getInstance().addLoggedUser(user);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("token","abcd");
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"id\":1,\"description\":\"jadson\"}",headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/topic"), HttpMethod.POST,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        System.out.println(response);
        UserLogin.getInstance().removeLoggedUser("abcd");
        assert response.getStatusCodeValue() == 406;
    }
}
