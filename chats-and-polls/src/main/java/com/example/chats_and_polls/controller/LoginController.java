package com.example.chats_and_polls.controller;

import com.example.chats_and_polls.service.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/grandcode")
    public String login(@RequestParam("code") String code,
                        @RequestParam("scope") String scope,
                        @RequestParam(value = "authuser", required = false) String authUser,
                        @RequestParam(value = "prompt", required = false) String prompt) throws JsonProcessingException {

        loginService.login(code, scope, authUser, prompt);

        return code;
    }

}