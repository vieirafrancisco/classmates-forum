package com.ufal.classmates_forum;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class TagControllerTests extends DefaultControllerTest {

    //Get a Tag test
    @Test
    public void testGetTag(){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/tag/1"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }
    //Get all tags test
    @Test
    public void testGetAllTags(){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/tags"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }
    //Create a tag test
    @Test
    public void testCreateTag(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"name\":\"jadson\"}",headers);
        String response = restTemplate.postForObject(createURLWithPort("/tag"),entity,String.class);
        System.out.println(response);
        assert response.contains("created");
    }
    //Delete a tag test
    @Test
    public void testDeleteTag(){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/tag/1"), HttpMethod.DELETE,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }
    //Tag Already Existis Test
    @Test
    public void testTagAlreadyExists(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"id\":1,\"name\":\"jadson\"}",headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/tag"), HttpMethod.POST,entity,String.class);
        assert response.getStatusCodeValue() == 406;
    }
    //Tag Not Found Test
    @Test
    public void testTagNotFound(){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/tag/149"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 404;
    }
}
