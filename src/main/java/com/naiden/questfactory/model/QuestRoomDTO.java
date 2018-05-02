package com.naiden.questfactory.model;

import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Collectors;

public class QuestRoomDTO {
    @Size(min = 3)
    private String name;
    private String description;
    private Set<QuestRoom> children;

    public QuestRoom toQuestRoom() {
        return new QuestRoom(this.name, this.description, this.children);
    }

    public QuestRoomDTO() {
    }

    public QuestRoomDTO(String name, String description, String entryPointName) {
        this.name = name;
        this.description = description;
        addChild(new QuestRoom(entryPointName));
    }

    public QuestRoomDTO(String name) {
        this.name = name;
    }

    public void addChild(QuestRoom child) {
        if (children == null) {
            children = new HashSet<>();
        }
        children.add(child);
    }

    public QuestRoomDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<QuestRoom> getChildren() {
        return children;
    }

    public void setChildren(Set<QuestRoom> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestRoomDTO quest = (QuestRoomDTO) o;
        return Objects.equals(name, quest.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    public String toString() {
        return this.name + "'s children => "
                + Optional.ofNullable(this.children).orElse(
                Collections.emptySet()).stream()
                .map(QuestRoom::getName)
                .collect(Collectors.toList());
    }
}
