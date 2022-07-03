package com.smalaca.jpa.persistence.author;

import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
@ToString
public class Author {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Address address;

    private Author() {}

    public Author(String name) {
        this.name = name;
    }

    void add(Address address) {
        this.address = address;
    }
}
