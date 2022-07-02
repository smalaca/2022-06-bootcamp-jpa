package com.smalaca.jpa.persistence.item;

import com.smalaca.jpa.persistence.RepositoriesFactory;
import com.smalaca.jpa.persistence.description.Description;

import java.util.List;

public class ItemTest {
    private static final RepositoriesFactory FACTORY = RepositoriesFactory.create();

    public static void main(String[] args) {
        addItems();
        findAll();

        FACTORY.close();
    }

    private static void findAll() {
        ItemRepository repository = FACTORY.itemRepository();
        List<Item> items = repository.findAll();
        items.forEach(System.out::println);
    }

    private static void addItems() {
        ItemRepository repository = FACTORY.itemRepository();
        repository.save(new Item("Item One", new Description("I hate long description", "But I hate more when I'm forced to write them.")));
        repository.save(new Item("Item Two"));
        repository.save(new Item("Item Three"));
    }
}
