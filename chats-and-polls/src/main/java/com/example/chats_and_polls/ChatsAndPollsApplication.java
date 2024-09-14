package com.example.chats_and_polls;

import com.example.chats_and_polls.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(Configuration.class)
public class ChatsAndPollsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatsAndPollsApplication.class, args);
    }

}
