package com.smalaca.jpa.persistence.item;

import com.smalaca.jpa.persistence.description.Description;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@ToString
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "shortDescription",
                    column = @Column(name = "ITEM_SHORT_DESC")),
            @AttributeOverride(
                    name = "longDescription",
                    column = @Column(name = "ITEM_DESC"))
    })
    private Description description;

    private Item() {}

    Item(String name, Description description) {
        this(name);
        this.description = description;
    }

    public Item(String name) {
        this.name = name;
    }
}
