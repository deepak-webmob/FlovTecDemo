package com.exchnage.demo.websocketConfig;

import com.exchnage.demo.models.TokenResponseObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class TokenManager {

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    @Autowired
    ObjectMapper objectMapper;

    public String getToken() throws JsonProcessingException {
        headers.setContentType(MediaType.APPLICATION_JSON);
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl("https://api.kucoin.com/api/v1/bullet-public");
        HttpEntity<?> entity = new HttpEntity<>(headers);
        System.out.println("=================>1");
        HttpEntity<TokenResponseObject> response = restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.POST,entity, TokenResponseObject.class);
        System.out.println(response.getBody().getData().getToken());
        System.out.println(response.getBody().getData().getInstanceServers().toString());
        return  response.getBody().getData().getToken();

    }
}
