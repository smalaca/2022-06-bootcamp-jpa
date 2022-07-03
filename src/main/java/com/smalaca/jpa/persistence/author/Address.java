package com.smalaca.jpa.persistence.author;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private UUID id;
    private String street;
    private String city;
    private String postalCode;
    private String country;

    @ManyToOne
    @JoinColumn(name = "ID_OF_AUTHOR")
//    @JoinTable(
//            name = "ADDRESSES_OF_AUTHOR",
//            joinColumns = {@JoinColumn(name = "ADD_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "AUTH_ID")}
//    )
    private Author author;

    public Address(String street, String city, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    private Address() {}

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", author=" + (author == null ? "NULL" : author.getName()) +
                '}';
    }

    void assignTo(Author author) {
        this.author = author;
    }
}
