package com.ufal.classmates_forum.testsControllers;

import com.ufal.classmates_forum.DefaultControllerTest;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class CommentControllerTests extends DefaultControllerTest {

    @Test
    public void testCreateComment(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"text\":\"TEXXXXXXXTO\",\"user_id\":2,\"post_id\":1}",headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/comment"), HttpMethod.POST,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 201;
    }
    @Test
    public void testGetAllComments(){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/comments"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }
    @Test
    public void testGetComment(){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/comment/1"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }
    @Test
    public void testDeleteComment(){
        headers.add("token","1");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/comment/1"), HttpMethod.DELETE,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }
    @Test
    public void testCommentIdAlreadyExists(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"id\":1,\"text\":\"TEXXXT\",\"user_id\":1,\"post_id\":1}",headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/comment"), HttpMethod.POST,entity,String.class);
        assert response.getStatusCodeValue() == 406;
    }
    @Test
    public void testCommentNotFound(){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/comment/150"), HttpMethod.GET,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 404;
    }
    @Test
    public void testDeleteNotAllowed(){
        headers.add("token","2");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/comment/1"), HttpMethod.DELETE,entity,String.class);
        System.out.println(response.getStatusCodeValue());
        assert response.getStatusCodeValue() == 200;
    }

}
