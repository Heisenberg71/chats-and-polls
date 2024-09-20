package com.example.chats_and_polls.service;

import com.example.chats_and_polls.payload.request.MessageRequest;
import com.example.chats_and_polls.payload.response.MessageResponse;

public interface MessageService {

    MessageResponse sendMessage(MessageRequest messageRequest);
}
