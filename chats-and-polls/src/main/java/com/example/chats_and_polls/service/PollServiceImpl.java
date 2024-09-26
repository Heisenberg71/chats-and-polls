package com.example.chats_and_polls.service;

import com.example.chats_and_polls.dao.GroupsDao;
import com.example.chats_and_polls.dao.OptionDao;
import com.example.chats_and_polls.dao.PollDao;
import com.example.chats_and_polls.dao.UsersDao;
import com.example.chats_and_polls.entity.Option;
import com.example.chats_and_polls.entity.Poll;
import com.example.chats_and_polls.payload.request.PollRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PollServiceImpl implements PollService {

    private final PollDao pollDao;
    private final OptionDao optionDao;
    private final UsersDao usersDao;
    private final GroupsDao groupsDao;

    public PollServiceImpl(PollDao pollDao, OptionDao optionDao, UsersDao usersDao, GroupsDao groupsDao) {
        this.pollDao = pollDao;
        this.optionDao = optionDao;
        this.usersDao = usersDao;
        this.groupsDao = groupsDao;
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
}
