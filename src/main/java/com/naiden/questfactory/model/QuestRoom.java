package com.naiden.questfactory.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Collectors;

@NodeEntity
public class QuestRoom {
    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 3)
    @Property
    private String name;

    @Property
    private String description;

    @Relationship(type = "hasChild")
    private Set<QuestRoom> children;

    public QuestRoom() {
    }

    public QuestRoom(String name, String description, String entryPointName) {
        this.name = name;
        this.description = description;
        addChild(new QuestRoom(entryPointName));
    }

    public QuestRoom(String name) {
        this.name = name;
    }

    public QuestRoom(String name, String description, Set<QuestRoom> children) {
        this.name = name;
        this.description = description;
        this.children = children;
    }

    public void addChild(QuestRoom child) {
        if (children == null) {
            children = new HashSet<>();
        }
        children.add(child);
    }

    public QuestRoom(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        QuestRoom quest = (QuestRoom) o;
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
