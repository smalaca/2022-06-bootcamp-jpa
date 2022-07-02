package com.smalaca.jpa.persistence.product;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

@Entity
@ToString
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @Transient
    private String shortDescription;

    private Product() {}

    public Product(String name, String description) {
        this(name);
        updateDescription(description);
    }

    public Product(String name) {
        this.name = name;
    }

    void updateDescription(String description) {
        this.description = description;
        updateShortDescription();
    }

    @PostLoad
    private void updateShortDescription() {
        if (description != null && description.length() > 40) {
            shortDescription = description.substring(0, 40) + "[...]";
        } else {
            shortDescription = description;
        }
    }

    Long getId() {
        return id;
    }
}
