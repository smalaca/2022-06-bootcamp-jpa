package com.smalaca.jpa.persistence.product;

import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "DESC", length = 200)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer amount;

    @Transient
    private String shortDescription;

    @ElementCollection
    @CollectionTable(name = "CATEGORIES")
    @Column(name = "CATEGORY")
    private Set<String> categories = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "RATINGS")
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "login", column = @Column(nullable = false)),
            @AttributeOverride(name = "value", column = @Column(name = "rating_value", nullable = false)),
            @AttributeOverride(name = "explanation", column = @Column(name = "rating_expl")),
    })
    private Set<Rating> ratings = new HashSet<>();

    private Product() {}

    public Product(String name, BigDecimal price, String description) {
        this(name, price);
        updateDescription(description);
    }

    public Product(String name, BigDecimal price) {
        this.name = name;
        amount = 1;
        this.price = price;
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

    public Long getId() {
        return id;
    }

    void addCategory(String category) {
        categories.add(category);
    }

    void add(Rating rating) {
        ratings.add(rating);
    }
}
