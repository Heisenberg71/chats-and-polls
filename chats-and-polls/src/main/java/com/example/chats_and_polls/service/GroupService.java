package com.example.chats_and_polls.service;

import com.example.chats_and_polls.payload.request.GroupCreationRequest;
import com.example.chats_and_polls.payload.response.GroupCreationResponse;

import java.util.List;

public interface GroupService {

    GroupCreationResponse create(GroupCreationRequest request);

    void joinGroup(String userId, Long groupId);

    List<GroupCreationResponse> getGroups(String userId);

    void leaveGroup(String userId, Long groupId);
}
