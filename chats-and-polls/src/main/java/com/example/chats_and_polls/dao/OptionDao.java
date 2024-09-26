package com.example.chats_and_polls.dao;

import com.example.chats_and_polls.entity.Option;

import java.util.List;

public interface OptionDao {

    List<Option> save(List<Option> optionList);

    Option getByOptionId(Long optionId);
}
