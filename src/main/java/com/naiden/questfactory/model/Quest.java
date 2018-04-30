package com.naiden.questfactory.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Collectors;

@NodeEntity
public class Quest {
    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 3)
    private String name;

    private String description;

    @Relationship(type = "CHILD", direction = Relationship.OUTGOING)
    public Set<Quest> children;

    public Quest() {
    }

    public void addChild(Quest child) {
        if (children == null) {
            children = new HashSet<>();
        }
        children.add(child);
    }

    public Quest(long id, String name, String description) {
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

    public Set<Quest> getChildren() {
        return children;
    }

    public void setChildren(Set<Quest> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quest quest = (Quest) o;
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
                .map(Quest::getName)
                .collect(Collectors.toList());
    }

}
