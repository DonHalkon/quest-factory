package com.naiden.questfactory.service;

import com.naiden.questfactory.model.QuestRoom;
import com.naiden.questfactory.repository.QuestRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestRoomService {
    private final QuestRoomRepository questRoomRepository;

    @Autowired
    public QuestRoomService(QuestRoomRepository questRoomRepository) {
        this.questRoomRepository = questRoomRepository;
    }


    public QuestRoom save(QuestRoom questRoom) {
        return questRoomRepository.save(questRoom);
    }
}
