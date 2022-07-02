package com.smalaca.jpa.persistence.todo;


import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.UUID;

@Entity
@Table(name = "TODOS")
@ToString
public class Todo {
    @Id
    @GeneratedValue
    @Column(name = "TODO_ID")
    private UUID id;

    @Column(name = "SUBJECT")
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
