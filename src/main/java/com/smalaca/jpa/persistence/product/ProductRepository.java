package com.smalaca.jpa.persistence.product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.UUID;

public class ProductRepository {
    private final EntityManager entityManager;

    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    Product findById(UUID id) {
        return entityManager.find(Product.class, id);
    }

    void save(Product product) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(product);
        transaction.commit();
    }

    List<Product> findAll() {
        return entityManager.createQuery("SELECT p FROM Product p").getResultList();
    }

    List<Product> findAllBy(String columnName) {
        if ("name".equals(columnName) || "description".equals(columnName)) {
            return entityManager.createQuery("SELECT p FROM Product p ORDER BY " + columnName).getResultList();
        } else {
            return entityManager.createQuery("SELECT p FROM Product p").getResultList();
        }
    }

    void deleteById(UUID id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(findById(id));
        transaction.commit();
    }
}
