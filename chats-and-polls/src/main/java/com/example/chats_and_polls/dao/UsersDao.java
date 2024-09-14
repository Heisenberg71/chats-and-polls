package com.example.chats_and_polls.dao;

import com.example.chats_and_polls.entity.Users;

public interface UsersDao {

    void save(Users users);

    Users findByUserId(String userId);
}
