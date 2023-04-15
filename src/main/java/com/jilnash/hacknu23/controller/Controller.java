package com.jilnash.hacknu23.controller;

import com.jayway.jsonpath.JsonPath;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/client/{iin}")
    public Map<String, String> getClientInfo(@PathVariable String iin) throws Exception {

        String link = "http://hakaton-fl.gov4c.kz/api/persons/" + iin;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req = HttpRequest.newBuilder()
                .GET()
                .setHeader("Authorization", "Bearer " + getToken())
                .uri(URI.create(link))
                .build();

        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

        Map<String, String> result = new HashMap<>();
        System.out.println();

        for(String data: res.body().split(",")) {

            String key = data.split(":")[0];
            key = key.substring(1, key.length()-1);

            String val = data.split(":")[1];
            val = val.substring(1, val.length()-1);

            result.put(key, val);
        }

        return result;
    }

    @GetMapping("/sms")
    public void sendSms(@RequestParam String phone, @RequestParam String text) throws Exception {

        String link = "http://hak-sms123.gov4c.kz/api/smsgateway/send";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers
                        .ofString("{\"phone\" : \"" + phone + "\", \"smsText\" : \"" + text + "\"}"))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", "Bearer " + getToken())
                .uri(URI.create(link))
                .build();

        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
    }

    @GetMapping("/phone/{iin}")
    public String getPhone(@PathVariable String iin) throws Exception {

        String link = "http://hakaton.gov4c.kz/api/bmg/check/" + iin;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req = HttpRequest.newBuilder()
                .GET()
                .setHeader("Authorization", "Bearer " + getToken())
                .uri(URI.create(link))
                .build();

        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

        return res.body().split(",")[1].split(":")[1];
    }
}
