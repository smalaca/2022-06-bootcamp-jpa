package com.smalaca.jpa.persistence.buyer;

import lombok.ToString;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@ToString
@Entity
public class Buyer {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private ContactDetails contactDetails;

    private Buyer() {}

    Buyer(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    Long getId() {
        return id;
    }
}
