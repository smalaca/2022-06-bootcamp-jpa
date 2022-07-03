package com.smalaca.jpa.persistence.author;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@ToString
public class Author {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private Author() {}

    public Author(String name) {
        this.name = name;
    }
}
