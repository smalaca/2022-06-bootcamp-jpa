package com.smalaca.jpa.persistence.todo;

import lombok.ToString;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@ToString
public class Comment {
    private String author;
    private LocalDate date;
    private String comment;

    private Comment() {}

    private Comment(String author, LocalDate date, String comment) {
        this.author = author;
        this.date = date;
        this.comment = comment;
    }

    static Comment now(String author, String comment) {
        return new Comment(author, LocalDate.now(), comment);
    }
}
