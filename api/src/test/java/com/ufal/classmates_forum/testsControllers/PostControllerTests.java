package com.ufal.classmates_forum.testsControllers;


import com.ufal.classmates_forum.DefaultControllerTest;
import org.junit.Test;
import org.springframework.http.*;

public class PostControllerTests extends DefaultControllerTest {

    @Test
    public void createPostTest(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"name\":\"Tagx\",\"content\":\"Something\"}",headers);
        String response = restTemplate.postForObject(createURLWithPort("/post"),entity,String.class);
        System.out.println(response);
        assert response.contains("created");
    }
    //Get all Posts test
    @Test
    public void testGetAllPosts(){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/posts"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }
    //Get a Post test
    @Test
    public void testGetPost(){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/post/1"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }
    //Delete a Post test
    @Test
    public void testDeletePost(){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/post/1"), HttpMethod.DELETE,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }
    //Post Id Already Exists test
    @Test
    public void testPostIdAlreadyExists(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"id\":1,\"name\":\"Tagx\",\"content\":\"Something\"}",headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/post"), HttpMethod.POST,entity,String.class);
        assert response.getStatusCodeValue() == 406;
    }
    //Post Not Found test
    @Test
    public void testPostNotFound(){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/post/150"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 404;
    }
}
