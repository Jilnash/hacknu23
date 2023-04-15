package com.jilnash.hacknu23.controller;

import com.jayway.jsonpath.JsonPath;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class Controller {

    @GetMapping("/token")
    public String getToken() {

        String url = "http://hakaton-idp.gov4c.kz/auth/realms/con-web/protocol/openid-connect/token";

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String reqBody = "username=test-operator&password=DjrsmA9RMXRl&client_id=cw-queue-service&grant_type=password";
        HttpEntity<String> entity = new HttpEntity<>(reqBody, headers);

        RestTemplate temp = new RestTemplate();

        ResponseEntity<String> res = temp.postForEntity(url, entity, String.class);

        return JsonPath.read(res.getBody(), "$.access_token");
    }
}
