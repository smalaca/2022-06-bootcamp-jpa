package com.smalaca.jpa.persistence.invoice;

import javax.persistence.EntityManager;
import java.util.List;

public class InvoiceRepository {
    private final EntityManager entityManager;

    public InvoiceRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    void save(Invoice invoice) {
        entityManager.getTransaction().begin();
        entityManager.persist(invoice);
        entityManager.getTransaction().commit();
    }

    List<Invoice> findAll() {
        return entityManager.createQuery("SELECT i FROM Invoice i").getResultList();
    }
}
