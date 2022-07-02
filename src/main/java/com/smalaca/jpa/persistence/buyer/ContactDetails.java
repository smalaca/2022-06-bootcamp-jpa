package com.smalaca.jpa.persistence.buyer;

import lombok.ToString;

import javax.persistence.Embeddable;

@ToString
@Embeddable
public class ContactDetails {
    private String login;
    private String phone;
    private String mail;

    private ContactDetails() {}

    public ContactDetails(String login, String phone, String mail) {
        this.login = login;
        this.phone = phone;
        this.mail = mail;
    }
}
