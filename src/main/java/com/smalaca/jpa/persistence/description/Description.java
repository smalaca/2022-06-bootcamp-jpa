package com.smalaca.jpa.persistence.description;

import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@ToString
public class Description {
    private String shortDescription;
    private String longDescription;

    private Description() {}

    public Description(String shortDescription, String longDescription) {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }
}
