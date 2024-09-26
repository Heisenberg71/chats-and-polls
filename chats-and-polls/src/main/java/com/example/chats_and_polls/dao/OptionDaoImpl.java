package com.example.chats_and_polls.dao;

import com.example.chats_and_polls.entity.Option;
import com.example.chats_and_polls.repository.OptionRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OptionDaoImpl implements OptionDao {

    private final OptionRepository optionRepository;

    public OptionDaoImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public List<Option> save(List<Option> optionList) {
        return optionRepository.saveAll(optionList);
    }

    @Override
    public Option getByOptionId(Long optionId) {

        return optionRepository.findById(optionId).get();
    }
}
