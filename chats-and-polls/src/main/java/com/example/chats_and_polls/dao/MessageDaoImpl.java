package com.example.chats_and_polls.dao;

import com.example.chats_and_polls.entity.Message;
import com.example.chats_and_polls.repository.MessageRepository;
import org.springframework.stereotype.Component;

@Component
public class MessageDaoImpl implements MessageDao {

    private final MessageRepository messageRepository;

    public MessageDaoImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message save(Message message) {

        return messageRepository.save(message);
    }
}
