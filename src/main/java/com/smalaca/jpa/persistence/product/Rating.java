package com.smalaca.jpa.persistence.product;

import lombok.ToString;

import javax.persistence.Embeddable;

@ToString
@Embeddable
public class Rating {
    private String login;
    private int value;
    private String explanation;

    private Rating() {}

    public Rating(String login, int value, String explanation) {
        this.login = login;
        this.value = value;
        this.explanation = explanation;
    }

    public Rating(String login, int value) {
        this.login = login;
        this.value = value;
    }
}
