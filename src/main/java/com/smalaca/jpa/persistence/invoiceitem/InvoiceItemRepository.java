package com.smalaca.jpa.persistence.invoiceitem;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class InvoiceItemRepository {
    private final EntityManager entityManager;

    public InvoiceItemRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    void save(InvoiceItem invoiceItem) {
        entityManager.getTransaction().begin();
        entityManager.persist(invoiceItem);
        entityManager.getTransaction().commit();
    }

    List<InvoiceItem> findAll() {
        return entityManager.createQuery("SELECT i FROM InvoiceItem i").getResultList();
    }

    void deleteById(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entityManager.find(InvoiceItem.class, id));
        transaction.commit();
    }

    void close() {
        entityManager.close();
    }
}
