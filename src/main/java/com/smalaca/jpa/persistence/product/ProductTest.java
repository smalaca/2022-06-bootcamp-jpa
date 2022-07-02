package com.smalaca.jpa.persistence.product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.UUID;

public class ProductTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ToDo");
        EntityManager entityManagerOne = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManagerOne.getTransaction();
        transaction.begin();
        UUID productIdOne = UUID.randomUUID();
        entityManagerOne.persist(new Product(productIdOne, "Tea"));
        UUID productIdTwo = UUID.randomUUID();
        entityManagerOne.persist(new Product(productIdTwo, "Coffee", "The best drink ever"));
        transaction.commit();

        entityManagerOne.close();

        EntityManager entityManagerTwo = entityManagerFactory.createEntityManager();

        System.out.println(entityManagerTwo.find(Product.class, productIdOne));
        System.out.println(entityManagerTwo.find(Product.class, productIdTwo));
        System.out.println(entityManagerTwo.find(Product.class, UUID.randomUUID()));

        entityManagerTwo.close();
    }
}
