package com.naiden.questfactory.controller;

import com.naiden.questfactory.model.Quest;
import com.naiden.questfactory.model.QuestDTO;
import com.naiden.questfactory.model.QuestRoom;
import com.naiden.questfactory.model.QuestRoomDTO;
import com.naiden.questfactory.service.QuestRoomService;
import com.naiden.questfactory.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping(value = "/quests")
public class QuestController {

    private final QuestService questService;
    private final QuestRoomService questRoomService;

    @Autowired
    public QuestController(QuestService questService, QuestRoomService questRoomService) {
        this.questService = questService;
        this.questRoomService = questRoomService;
    }

    @GetMapping(value = "quests")
    public String getAllQuests(Map<String, Object> model) {
        model.put("quests", questService.getAllQuests());
        return "quests";
    }

    @GetMapping(value = "create-quest")
    public String createQuest(){
        return "create-quest";
    }

    @GetMapping(value = "add-quest-room")
    public String addQuestRoom(QuestRoom questRoom, Model model) {
        //FixMe: add quest name form (without edit option)
        model.addAttribute("questRoom", questRoom);
        return "add-quest-room";
    }

    @PostMapping(value = "add-quest-room")
    public String addQuestRoom(QuestRoomDTO questRoomDTO, RedirectAttributes model) {
        QuestRoom questRoom = questRoomService.save(questRoomDTO.toQuestRoom());
        model.addFlashAttribute("questRoom", questRoom);
        return "redirect:add-quest-room";
    }

    @PostMapping(value = "save-quest-room")
    public String saveQuestRoom(QuestRoomDTO questRoomDTO, RedirectAttributes model) {
        QuestRoom questRoom = questRoomService.save(questRoomDTO.toQuestRoom());
        model.addFlashAttribute(questRoom);
        return "redirect:add-quest-room";
    }


    @PostMapping(value = "save-quest")
    public String saveQuest(@Valid QuestDTO questDTO, RedirectAttributes model) {
        Quest quest = questService.save(questDTO.toQuest());
        model.addFlashAttribute(quest.getEntryPoint());
        return "redirect:add-quest-room";
    }
}
