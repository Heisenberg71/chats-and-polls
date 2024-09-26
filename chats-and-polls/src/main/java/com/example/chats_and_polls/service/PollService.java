package com.example.chats_and_polls.service;

import com.example.chats_and_polls.payload.request.PollRequest;

public interface PollService {

    void create(PollRequest request);
}
