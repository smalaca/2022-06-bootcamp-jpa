package com.smalaca.jpa.persistence.invoice;

import com.smalaca.jpa.persistence.invoiceitem.InvoiceItem;
import com.smalaca.jpa.persistence.offer.Offer;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
public class Invoice {
    @Id
    @GeneratedValue
    private Long id;

    private InvoiceStatus status = InvoiceStatus.CREATED;

    @OneToOne
    private Offer offer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<InvoiceItem> items = new ArrayList<>();

    void sent() {
        status = InvoiceStatus.SENT;
    }

    void payed() {
        status = InvoiceStatus.PAYED;
    }

    public void add(Offer offer) {
        this.offer = offer;
    }

    void add(InvoiceItem invoiceItem) {
        items.add(invoiceItem);
    }
}
