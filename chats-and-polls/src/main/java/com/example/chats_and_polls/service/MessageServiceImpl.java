package com.example.chats_and_polls.service;

import com.example.chats_and_polls.dao.GroupsDao;
import com.example.chats_and_polls.dao.MessageDao;
import com.example.chats_and_polls.dao.UsersDao;
import com.example.chats_and_polls.entity.Message;
import com.example.chats_and_polls.payload.request.MessageRequest;
import com.example.chats_and_polls.payload.response.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private final GroupsDao groupsDao;
    private final UsersDao usersDao;
    private final MessageDao messageDao;

    public MessageServiceImpl(GroupsDao groupsDao, UsersDao usersDao, MessageDao messageDao) {
        this.groupsDao = groupsDao;
        this.usersDao = usersDao;
        this.messageDao = messageDao;
    }

    @Override
    public MessageResponse sendMessage(MessageRequest messageRequest) {

        Message message = Message.builder()
                .groupId(messageRequest.getGroupId())
                .userId(messageRequest.getUserId())
                .message(messageRequest.getMessage())
                .build();

        messageDao.save(message);

        return MessageResponse.builder()
                .groupId(messageRequest.getGroupId())
                .userId(messageRequest.getUserId())
                .message(message.getMessage())
                .status("success")
                .build();
    }
}
