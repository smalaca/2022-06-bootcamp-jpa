package com.smalaca.jpa.persistence.product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.UUID;

public class ProductTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ToDo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(new Product(UUID.randomUUID(), "Tea"));
        entityManager.persist(new Product(UUID.randomUUID(), "Coffee", "The best drink ever"));

        transaction.commit();

        entityManager.close();
    }
}
