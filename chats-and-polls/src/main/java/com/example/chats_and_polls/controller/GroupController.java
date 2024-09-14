package com.example.chats_and_polls.controller;

import com.example.chats_and_polls.payload.request.GroupCreationRequest;
import com.example.chats_and_polls.payload.response.GroupCreationResponse;
import com.example.chats_and_polls.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/groups")
    public GroupCreationResponse create(@RequestBody GroupCreationRequest request) {

        return groupService.create(request);
    }

    @PostMapping("/group-enrollment/user-id/{userId}/group-id/{groupId}")
    public void joinGroup(@PathVariable String userId, @PathVariable Long groupId){

        groupService.joinGroup(userId, groupId);
    }

    @GetMapping("/user-id/{userId}")
    public List<GroupCreationResponse> getGroups(@PathVariable String userId){

        return groupService.getGroups(userId);
    }
}
