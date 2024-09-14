package com.example.chats_and_polls.service;

import com.example.chats_and_polls.dao.UsersDao;
import com.example.chats_and_polls.dto.AccessTokenDetails;
import com.example.chats_and_polls.entity.Users;
import com.example.chats_and_polls.gateway.AuthServerGateway;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final AuthServerGateway authServerGateway;
    private final ObjectMapper objectMapper;
    private final UsersDao usersDao;

    public LoginServiceImpl(AuthServerGateway authServerGateway,
                            ObjectMapper objectMapper, UsersDao usersDao) {
        this.authServerGateway = authServerGateway;
        this.objectMapper = objectMapper;
        this.usersDao = usersDao;
    }

    @Override
    public void login(String code, String scope, String authUser, String prompt) throws JsonProcessingException {

        String accessToken = authServerGateway.getAccessToken(code);
        log.info("Access token: {}", accessToken);

        AccessTokenDetails accessTokenDetails = objectMapper.readValue(accessToken, AccessTokenDetails.class);
        log.info("Access token Dto: {}", accessTokenDetails);

        ResponseEntity<String> userInfo = authServerGateway.getProfile(accessTokenDetails.getAccessToken());
        log.info("User info: {}", userInfo.getBody());

        Users users = objectMapper.readValue(userInfo.getBody(), Users.class);
        log.info("User Info: {}", users);

        usersDao.save(users);
    }
}
