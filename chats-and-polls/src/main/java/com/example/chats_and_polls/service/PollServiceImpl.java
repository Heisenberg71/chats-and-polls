package com.example.chats_and_polls.service;

import com.example.chats_and_polls.dao.*;
import com.example.chats_and_polls.entity.Option;
import com.example.chats_and_polls.entity.Poll;
import com.example.chats_and_polls.entity.Users;
import com.example.chats_and_polls.entity.Vote;
import com.example.chats_and_polls.payload.request.PollRequest;
import com.example.chats_and_polls.payload.request.VoteRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PollServiceImpl implements PollService {

    private final PollDao pollDao;
    private final OptionDao optionDao;
    private final UsersDao usersDao;
    private final GroupsDao groupsDao;
    private final VoteDao voteDao;

    public PollServiceImpl(PollDao pollDao, OptionDao optionDao, UsersDao usersDao, GroupsDao groupsDao, VoteDao voteDao) {
        this.pollDao = pollDao;
        this.optionDao = optionDao;
        this.usersDao = usersDao;
        this.groupsDao = groupsDao;
        this.voteDao = voteDao;
    }

    @Override
    public void create(PollRequest request) {

        Poll poll = Poll.builder()
                .users(usersDao.findByUserId(request.getPollCreatorId()))
                .groups(groupsDao.findByGroupId(request.getGroupId()))
                .question(request.getQuestion())
                .build();

        pollDao.save(poll);

        List<Option> optionList = new ArrayList<>();

        for(String optionString : request.getOptions()) {
            Option option = Option.builder()
                    .poll(poll)
                    .option_text(optionString)
                    .build();
            optionList.add(option);
        }

        optionDao.save(optionList);
    }

    @Override
    public void castVote(VoteRequest request) {

        Poll poll = pollDao.getByPollId(request.getPollId());
        Option option = optionDao.getByOptionId(request.getOptionId());
        Users user = usersDao.findByUserId(request.getUserId());

        Vote vote = Vote.builder()
                .poll(poll)
                .option(option)
                .users(user)
                .build();

        voteDao.save(vote);
    }
}
