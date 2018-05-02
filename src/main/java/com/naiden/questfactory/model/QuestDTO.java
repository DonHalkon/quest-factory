package com.naiden.questfactory.model;

import javax.validation.constraints.Size;

public class QuestDTO {

    @Size(min = 3)
    private String name;
    private String description;
    private String entryPointName;

    public Quest toQuest() {
        return new Quest(name, description, entryPointName);
    }

    public QuestDTO() {
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

    public String getEntryPointName() {
        return entryPointName;
    }

    public void setEntryPointName(String entryPointName) {
        this.entryPointName = entryPointName;
    }
}
