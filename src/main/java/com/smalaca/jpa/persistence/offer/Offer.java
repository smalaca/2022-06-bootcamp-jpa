package com.smalaca.jpa.persistence.offer;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@ToString
@Entity
public class Offer {
    @Id
    @GeneratedValue
    private UUID id;

    private String offerNumber;

    private Offer() {}

    Offer(String offerNumber) {
        this.offerNumber = offerNumber;
    }
}
