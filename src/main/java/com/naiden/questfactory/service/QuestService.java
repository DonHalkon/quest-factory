package com.naiden.questfactory.service;

import com.naiden.questfactory.model.Quest;
import com.naiden.questfactory.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestService {

    private final QuestRepository questRepository;

    @Autowired
    public QuestService(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    public Quest getQuestById(Long id) {
        //FIXME: get!
        return questRepository.findById(id).get();
    }

    public List<Quest> getAllQuests() {
        return questRepository.findAll();
    }

    public void save(Quest quest) {
        questRepository.save(quest);
    }
}
