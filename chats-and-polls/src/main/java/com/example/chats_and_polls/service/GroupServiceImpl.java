package com.example.chats_and_polls.service;

import com.example.chats_and_polls.dao.GroupsDao;
import com.example.chats_and_polls.dao.UsersDao;
import com.example.chats_and_polls.entity.Groups;
import com.example.chats_and_polls.entity.Users;
import com.example.chats_and_polls.payload.request.GroupCreationRequest;
import com.example.chats_and_polls.payload.response.GroupCreationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class GroupServiceImpl implements GroupService {

    private final GroupsDao groupsDao;
    private final UsersDao usersDao;

    Random random = new Random();

    public GroupServiceImpl(GroupsDao groupsDao, UsersDao usersDao) {
        this.groupsDao = groupsDao;
        this.usersDao = usersDao;
    }

    @Override
    public GroupCreationResponse create(GroupCreationRequest request) {

        log.info("Group creation request: {}", request);

        Groups groups = Groups.builder()
                .name(request.getGroupName())
                .adminId(request.getAdminId())
                .code(generateCode().toString())
                .build();

        log.info("groups: {}", groups);

        groupsDao.save(groups);

        log.info("groups: {}", groups);

        joinGroup(request.getAdminId(), groups.getId());

        return GroupCreationResponse.builder()
                .groupId(groups.getId())
                .groupName(groups.getName())
                .groupCode(groups.getCode())
                .adminId(groups.getAdminId())
                .build();
    }


    private Long generateCode() {

        long firstDigit = 1 + random.nextInt(9);
        long remainingDigits = random.nextLong(900000000L) + 100000000L;

        return firstDigit * 1000000000L + remainingDigits;
    }
    @Override
    public void joinGroup(String userId, Long groupId) {

        Users users = usersDao.findByUserId(userId);
        Groups groups = groupsDao.finByGroupId(groupId);

        users.getGroups().add(groups);
        usersDao.save(users);
    }

    @Override
    public List<GroupCreationResponse> getGroups(String userId) {

        Users users = usersDao.findByUserId(userId);

        List<Groups> groupsList = users.getGroups();

        List<GroupCreationResponse> responseList = new ArrayList<GroupCreationResponse>();
        for(Groups group: groupsList){
            responseList.add(GroupCreationResponse.builder()
                            .groupId(group.getId())
                            .groupName(group.getName())
                            .groupCode(group.getCode())
                            .adminId(group.getAdminId())
                    .build());
        }

        return responseList;
    }


}
