package com.smalaca.jpa.persistence.buyer;

import javax.persistence.EntityManager;
import java.util.List;

public class BuyerRepository {
    private final EntityManager entityManager;

    public BuyerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Long save(Buyer buyer) {
        entityManager.getTransaction().begin();
        entityManager.persist(buyer);
        entityManager.getTransaction().commit();
        return buyer.getId();
    }

    public List<Buyer> findAll() {
        return entityManager.createQuery("SELECT i FROM Buyer i").getResultList();
    }
}
