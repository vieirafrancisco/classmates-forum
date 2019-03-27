package com.ufal.classmates_forum;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

public class PostControllerTests extends DefaultControllerTest{

    @Test
    public void createPostTest(){
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(
                "{\"name\":\"Tagx\",\"content\":\"Something\"}",headers);
        String response = restTemplate.postForObject(createURLWithPort("/post"),entity,String.class);
        System.out.println(response);
        assert response.contains("created");
    }
}
