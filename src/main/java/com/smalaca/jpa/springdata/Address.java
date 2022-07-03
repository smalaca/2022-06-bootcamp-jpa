package com.smalaca.jpa.springdata;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@ToString
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String street;
    private String postalCode;
    private String city;
    private String country;

    private Address() {}

    Address(String street, String postalCode, String city, String country) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }
}
