package com.smalaca.jpa.persistence.invoiceitem;

import com.smalaca.jpa.persistence.product.Product;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
@ToString
public class InvoiceItem {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    private Product product;
    private int amount;

    public InvoiceItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public InvoiceItem() {}
}
