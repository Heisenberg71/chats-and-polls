package com.example.chats_and_polls.dao;

import com.example.chats_and_polls.entity.Poll;

public interface PollDao {

    Poll save(Poll poll);

    Poll getByPollId(Long pollId);
}
