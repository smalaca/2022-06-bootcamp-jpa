package com.smalaca.jpa.persistence.product;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@ToString
public class Product {
    @Id
    private Long id;
    private String name;
    private String description;

    private Product() {}

    public Product(Long id, String name, String description) {
        this(id, name);
        this.description = description;
    }

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
