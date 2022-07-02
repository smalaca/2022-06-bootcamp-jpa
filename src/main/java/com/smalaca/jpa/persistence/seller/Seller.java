package com.smalaca.jpa.persistence.seller;

import com.smalaca.jpa.persistence.contactdetails.ContactDetails;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@ToString
@Entity
public class Seller {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "phone", column = @Column(name = "SELLER_PHONE")),
            @AttributeOverride(name = "mail", column = @Column(name = "SELLER_MAIL"))
    })
    private ContactDetails contactDetails;

    private Seller() {}

    Seller(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    Long getId() {
        return id;
    }
}
