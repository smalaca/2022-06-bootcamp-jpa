package com.smalaca.jpa.persistence.todo;


import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@ToString
public class Todo {
    @Id
    private UUID id;

    @Column(name = "name")
    private String subject;

    private Todo() {}

    public Todo(UUID id, String subject) {
        this.id = id;
        this.subject = subject;
    }
}
