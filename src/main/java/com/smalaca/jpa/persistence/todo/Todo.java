package com.smalaca.jpa.persistence.todo;


import com.smalaca.jpa.persistence.description.Description;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TODOS")
@ToString
public class Todo {
    @Id
    @GeneratedValue
    @Column(name = "TODO_ID")
    private UUID id;

    @Column(name = "SUBJECT", unique = true, nullable = false)
    private String subject;

    @Column(name = "DETAILS", columnDefinition = "CLOB")
    private String details;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "shortDescription",
                    column = @Column(name = "TODO_SHORT_DESC")),
            @AttributeOverride(
                    name = "longDescription",
                    column = @Column(name = "TODO_DESC"))
    })
    private Description description;

    @Transient
    private String firstLetterOfSubject;

    @Enumerated(EnumType.STRING)
    private TodoStatus status = TodoStatus.NOT_DEFINED;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "TODO_COMMENTS",
            joinColumns = {
                    @JoinColumn(name = "TODO_ID")
            })
    @Column(name = "COMMENT", columnDefinition = "CLOB")
    private Set<String> comments = new HashSet<>();

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

    void defined() {
        status = TodoStatus.DEFINED;
    }

    void inProgress() {
        status = TodoStatus.IN_PROGRESS;
    }

    void set(Description description) {
        this.description = description;
    }

    void addComment(String comment) {
        comments.add(comment);
    }
}
