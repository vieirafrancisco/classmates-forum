package com.ufal.classmates_forum;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class TopicControllerTests extends DefaultControllerTest {

    //Create Topic test
    @Test
    public void testCreateTopic(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"description\":\"jadson\"}",headers);
        String response = restTemplate.postForObject(createURLWithPort("/topic"),entity,String.class);
        System.out.println(response);
        assert response.contains("create");
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
    //Get All Topics test
    @Test
    public void testGetAllTopics(){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/topics"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }
    //Delete topic test
    @Test
    public void testDeleteTopic(){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/topic/1"), HttpMethod.DELETE,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }
}
