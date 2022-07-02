package com.smalaca.jpa.persistence.item;

import javax.persistence.EntityManager;
import java.util.List;

public class ItemRepository {
    private final EntityManager entityManager;

    public ItemRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    void save(Item item) {
        entityManager.getTransaction().begin();
        entityManager.persist(item);
        entityManager.getTransaction().commit();
    }

    List<Item> findAll() {
        return entityManager.createQuery("SELECT i FROM Item i").getResultList();
    }
}
