package com.example.chats_and_polls.gateway;

import com.example.chats_and_polls.config.Configuration;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthServerGatewayImpl implements AuthServerGateway {

    private final RestTemplate restTemplate = new RestTemplate();
    private final Configuration configuration;

    public AuthServerGatewayImpl(Configuration configuration) {
        this.configuration = configuration;
    }


    @Override
    public String getAccessToken(String code) {

        String clientId = configuration.getClientId();
        String clientSecret = configuration.getClientSecret();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = getStringStringMultiValueMap(code, clientId, clientSecret);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, httpHeaders);

        String url = configuration.getTokenUrl();
        return restTemplate.postForObject(url, requestEntity, String.class);
    }


    private static MultiValueMap<String, String> getStringStringMultiValueMap(String code, String clientId, String clientSecret) {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", code);
        params.add("redirect_uri", "https://localhost:8080/grandcode");
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("scope", "https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile");
        params.add("scope", "https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email");
        params.add("scope", "openid");
        params.add("grant_type", "authorization_code");
        return params;
    }

    @Override
    public ResponseEntity<String> getProfile(String accessToken) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(accessToken);

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        String url = configuration.getUserInfoUrl();
        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
    }
}
