package com.example.chats_and_polls.gateway;

import org.springframework.http.ResponseEntity;

public interface AuthServerGateway {

    String getAccessToken(String code);

    ResponseEntity<String> getProfile(String accessToken);
}
