package com.example.chats_and_polls.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface LoginService {

    void login(String code, String scope, String authUser, String prompt) throws JsonProcessingException;
}
