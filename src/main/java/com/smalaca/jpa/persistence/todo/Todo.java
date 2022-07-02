package com.smalaca.jpa.persistence.todo;


import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@ToString
public class Todo {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String subject;

    private Todo() {}

    public Todo(String subject) {
        this.subject = subject;
    }

    void changeSubjectTo(String subject) {
        this.subject = subject;
    }

    UUID getId() {
        return id;
    }
}
