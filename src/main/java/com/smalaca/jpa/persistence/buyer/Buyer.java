package com.smalaca.jpa.persistence.buyer;

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
public class Buyer {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "login", column = @Column(name = "BUY_LOGIN")),
            @AttributeOverride(name = "phone", column = @Column(name = "PHONE_NUMBER")),
            @AttributeOverride(name = "mail", column = @Column(name = "MAIL_ADDRESS"))
    })
    private ContactDetails contactDetails;

    private Buyer() {}

    Buyer(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    Long getId() {
        return id;
    }
}
