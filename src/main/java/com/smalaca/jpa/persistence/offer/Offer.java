package com.smalaca.jpa.persistence.offer;

import com.smalaca.jpa.persistence.offeritem.OfferItem;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ToString
@Entity
public class Offer {
    @Id
    @GeneratedValue
    private UUID id;

    private String offerNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OfferItem> items = new ArrayList<>();

    private Offer() {}

    public Offer(String offerNumber) {
        this.offerNumber = offerNumber;
    }

    public void add(OfferItem offerItem) {
        items.add(offerItem);
    }
}
