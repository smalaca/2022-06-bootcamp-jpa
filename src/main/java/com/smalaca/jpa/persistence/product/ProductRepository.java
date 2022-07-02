package com.smalaca.jpa.persistence.product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ProductRepository {
    private final EntityManager entityManager;

    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    Long save(Product product) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(product);
        transaction.commit();

        return product.getId();
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

    void deleteById(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.createQuery("DELETE FROM Product WHERE id = '" + id + "'").executeUpdate();
//        entityManager.remove(findById(id));
        transaction.commit();
    }

    void update(Product product) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(product);
        transaction.commit();
    }
}
