package com.example.chats_and_polls.dao;

import com.example.chats_and_polls.entity.Groups;
import com.example.chats_and_polls.repository.GroupsRepository;
import org.springframework.stereotype.Component;

@Component
public class GroupsDaoImpl implements GroupsDao {

    private final GroupsRepository groupsRepository;

    public GroupsDaoImpl(GroupsRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

    @Override
    public Groups save(Groups groups) {

        return groupsRepository.save(groups);
    }

    @Override
    public Groups findByGroupId(Long groupId) {

        return groupsRepository.findById(groupId).orElse(null);
    }
}
