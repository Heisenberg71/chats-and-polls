package com.example.chats_and_polls.controller;

import com.example.chats_and_polls.payload.request.PollRequest;
import com.example.chats_and_polls.payload.request.VoteRequest;
import com.example.chats_and_polls.service.PollService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PollController {

    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping("/polls")
    void createPoll(@RequestBody PollRequest request) {

        pollService.create(request);
    }

    @PostMapping("/vote")
    void castVote(@RequestBody VoteRequest request){

        pollService.castVote(request);
    }
}
