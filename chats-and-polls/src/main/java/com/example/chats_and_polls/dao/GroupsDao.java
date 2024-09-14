package com.example.chats_and_polls.dao;

import com.example.chats_and_polls.entity.Groups;

public interface GroupsDao {

    Groups save(Groups groups);

    Groups finByGroupId(Long groupId);
}
