package org.shdennlin.cms.controller;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootTest
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductControllerTests {
    @Test
    @GetMapping("/products/{id}")
    public void testGet(){

//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:8080/products/B0001";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE));
//        String body = "{\n" +
//                "    \"id\": \"B0004\",\n" +
//                "    \"name\": \"Finance Management\",\n" +
//                "    \"price\": 450\n" +
//                "}";
//        HttpEntity<String> entity = new HttpEntity<String>(body, headers);
//        restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }
}
