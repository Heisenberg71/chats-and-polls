package com.example.chats_and_polls.service;

import com.example.chats_and_polls.payload.request.PollRequest;
import com.example.chats_and_polls.payload.request.VoteRequest;

public interface PollService {

    void create(PollRequest request);

    void castVote(VoteRequest request);
}
