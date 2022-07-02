package com.smalaca.jpa.persistence.invoice;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@ToString
public class Invoice {
    @Id
    @GeneratedValue
    private Long id;

    private InvoiceStatus status = InvoiceStatus.CREATED;

    void sent() {
        status = InvoiceStatus.SENT;
    }

    void payed() {
        status = InvoiceStatus.PAYED;
    }
}
