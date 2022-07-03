package com.smalaca.jpa.persistence.invoiceitem;

import com.smalaca.jpa.persistence.product.Product;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@ToString
public class InvoiceItem {
    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @OneToOne
    private Product product;
    private int amount;

    public InvoiceItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public InvoiceItem() {}
}
