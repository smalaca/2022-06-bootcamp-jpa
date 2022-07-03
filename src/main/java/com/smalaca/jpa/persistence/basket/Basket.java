package com.smalaca.jpa.persistence.basket;

import lombok.ToString;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ToString
@Entity
public class Basket {
    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection
    @CollectionTable(name = "PRODUCTS_IN_BASKET")
    @MapKeyColumn(name = "product_id")
    @Column(name = "amount")
    private Map<Long, Integer> products = new HashMap<>();

    @Convert(converter = BasketIdentifierConverter.class)
    @Column(name = "BASKET_ID", unique = true, nullable = false)
    private BasketIdentifier basketIdentifier = BasketIdentifier.now(UUID.randomUUID().toString(), -1);

    public void addProducts(Long id, int amount) {
        products.put(id, amount);
    }

    void add(BasketIdentifier basketIdentifier) {
        this.basketIdentifier = basketIdentifier;
    }
}
