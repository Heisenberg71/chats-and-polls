package com.example.chats_and_polls.controller;

import com.example.chats_and_polls.payload.request.MessageRequest;
import com.example.chats_and_polls.payload.response.MessageResponse;
import com.example.chats_and_polls.service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/messages")
    public MessageResponse sendMessage(@RequestBody MessageRequest message) {

        return messageService.sendMessage(message);
    }
}
