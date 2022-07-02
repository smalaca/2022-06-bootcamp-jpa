package com.smalaca.jpa.persistence.product;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@ToString
public class Product {
    @Id
    private UUID id;
    private String name;
    private String description;

    public Product(UUID id, String name, String description) {
        this(id, name);
        this.description = description;
    }

    public Product(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
