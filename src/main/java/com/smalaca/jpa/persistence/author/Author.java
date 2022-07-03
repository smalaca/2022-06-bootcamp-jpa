package com.smalaca.jpa.persistence.author;

import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@ToString
public class Author {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "author")
//    @JoinTable(
//            name = "ADDRESSES_OF_AUTHOR",
//            joinColumns = {@JoinColumn(name = "AUTH_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "ADD_ID")}
//    )
    private Set<Address> addresses = new HashSet<>();

    private Author() {}

    public Author(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void add(Address address) {
        addresses.add(address);
    }
}
