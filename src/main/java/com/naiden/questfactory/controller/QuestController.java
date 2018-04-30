package com.naiden.questfactory.controller;

import com.naiden.questfactory.model.Quest;
import com.naiden.questfactory.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping(value = "/quests")
public class QuestController {

    private final QuestService questService;

    @Autowired
    public QuestController(QuestService questService) {
        this.questService = questService;
    }

    @GetMapping(value = "quests")
    public String getAllQuests(Map<String, Object> model) {
        model.put("quests", questService.getAllQuests());
        return "quests";
    }

    @GetMapping(value = "create")
    public String createQuest(){
        return "create-quest";
    }


    @PostMapping(value = "save")
    public String saveQuest(@Valid Quest quest){
        questService.save(quest);
        return "redirect:quests";
    }
}
