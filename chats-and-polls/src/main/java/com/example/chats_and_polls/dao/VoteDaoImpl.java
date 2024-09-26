package com.example.chats_and_polls.dao;

import com.example.chats_and_polls.entity.Vote;
import com.example.chats_and_polls.repository.VoteRepository;
import org.springframework.stereotype.Component;

@Component
public class VoteDaoImpl implements VoteDao {

    private final VoteRepository voteRepository;

    public VoteDaoImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public Vote save(Vote vote) {

        return voteRepository.save(vote);
    }
}
