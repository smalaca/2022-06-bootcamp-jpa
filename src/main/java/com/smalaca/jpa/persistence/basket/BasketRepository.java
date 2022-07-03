package com.smalaca.jpa.persistence.basket;

import javax.persistence.EntityManager;
import java.util.List;

public class BasketRepository {
    private final EntityManager entityManager;

    public BasketRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Basket buyer) {
        entityManager.getTransaction().begin();
        entityManager.persist(buyer);
        entityManager.getTransaction().commit();
    }

    public List<Basket> findAll() {
        return entityManager.createQuery("SELECT b FROM Basket b").getResultList();
    }
}
