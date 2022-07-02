package com.smalaca.jpa.persistence.todo;


import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;
import java.util.UUID;

@Entity
@ToString
public class Todo {
    @Id
    @GeneratedValue
    private UUID id;

    private String subject;

    @Transient
    private String firstLetterOfSubject;

    private Todo() {}

    public Todo(String subject) {
        this.subject = subject;
        calculateFirstLetterOfSubject();
    }

    @PostLoad
    private void calculateFirstLetterOfSubject() {
        firstLetterOfSubject = subject.substring(0, 1);
    }

    void changeSubjectTo(String subject) {
        this.subject = subject;
    }

    UUID getId() {
        return id;
    }
}
