package com.smalaca.jpa.persistence.invoice;

import com.smalaca.jpa.persistence.offer.Offer;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@ToString
public class Invoice {
    @Id
    @GeneratedValue
    private Long id;

    private InvoiceStatus status = InvoiceStatus.CREATED;

    @OneToOne
    private Offer offer;

    void sent() {
        status = InvoiceStatus.SENT;
    }

    void payed() {
        status = InvoiceStatus.PAYED;
    }

    public void add(Offer offer) {
        this.offer = offer;
    }
}
