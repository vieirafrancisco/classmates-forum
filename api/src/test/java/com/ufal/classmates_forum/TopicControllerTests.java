package com.ufal.classmates_forum;

import com.ufal.classmates_forum.exceptions.UserAlreadyLoggedException;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class TopicControllerTests extends DefaultControllerTest {

    //Create Topic test
    @Test
    public void testCreateTopic() throws Exception{
        UserLogin.getInstance().addLoggedUser("abcd","admin");
        headers.add("token","abcd");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"description\":\"jadson\"}",headers);
        String response = restTemplate.postForObject(createURLWithPort("/topic"),entity,String.class);
        System.out.println(response);
        UserLogin.getInstance().removeLoggedUser("abcd");
        assert response.contains("create");
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
                createURLWithPort("/tag/1"), HttpMethod.GET,entity,String.class);
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
                createURLWithPort("/tag/134"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 404;
    }
    //Topic Id Already Existis
    @Test
    public void testTopicIdAlreadyExists(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"id\":1,\"description\":\"jadson\"}",headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/tag"), HttpMethod.POST,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 406;
    }
}
