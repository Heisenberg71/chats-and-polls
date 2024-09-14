package com.example.chats_and_polls.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("google.auth")
public class Configuration {

    private String clientId;
    private String clientSecret;
    private String tokenUrl;
    private String userInfoUrl;
}
