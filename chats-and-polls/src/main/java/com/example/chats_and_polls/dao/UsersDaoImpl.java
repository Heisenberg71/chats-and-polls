package com.example.chats_and_polls.dao;

import com.example.chats_and_polls.entity.Users;
import com.example.chats_and_polls.repository.UsersRepository;
import org.springframework.stereotype.Component;

@Component
public class UsersDaoImpl implements UsersDao {

    private final UsersRepository usersRepository;

    public UsersDaoImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void save(Users users) {
        usersRepository.save(users);
    }

    @Override
    public Users findByUserId(String userId) {

        return usersRepository.findById(userId).orElse(null);
    }
}
