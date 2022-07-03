package com.smalaca.jpa.springdata;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String manufacturer;
    private String description;
    private int price;

    public Product(String name, String manufacturer, String description, int price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.description = description;
        this.price = price;
    }
}
