package com.example.chats_and_polls.dao;

import com.example.chats_and_polls.entity.Poll;
import com.example.chats_and_polls.repository.PollRepository;
import org.springframework.stereotype.Component;

@Component
public class PollDaoImpl implements PollDao {

    private final PollRepository pollRepository;

    public PollDaoImpl(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @Override
    public Poll save(Poll poll) {

        return pollRepository.save(poll);
    }
}
