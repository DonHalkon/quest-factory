package com.naiden.questfactory.service;

import com.naiden.questfactory.model.Quest;
import com.naiden.questfactory.repository.QuestRepository;
import com.naiden.questfactory.repository.QuestRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestService {

    private final QuestRepository questRepository;
    private final QuestRoomRepository questRoomRepository;

    @Autowired
    public QuestService(QuestRepository questRepository, QuestRoomRepository questRoomRepository) {
        this.questRepository = questRepository;
        this.questRoomRepository = questRoomRepository;
    }

    public Quest getQuestById(Long id) {
        //FIXME: get!
        return questRepository.findById(id).get();
    }

    public List<Quest> getAllQuests() {
        return questRepository.findAll();
    }

    public Quest save(Quest quest) {
        return questRepository.save(quest);
    }
}
