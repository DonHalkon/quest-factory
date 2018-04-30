package com.naiden.questfactory.repository;

import com.naiden.questfactory.model.Quest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestRepository extends CrudRepository<Quest, Long> {
    public List<Quest> findAll();
    public Quest findByName(String questName);
}
