package com.smalaca.jpa.persistence.todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.UUID;

public class TodoTest {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ToDo");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(new Todo(UUID.randomUUID(), "conduct JPA training"));
        System.out.println("BEFORE FLUSH");
        entityManager.flush();
        System.out.println("AFTER FLUSH");
        entityManager.persist(new Todo(UUID.randomUUID(), "conduct ORM training"));
        entityManager.persist(new Todo(UUID.randomUUID(), "conduct Hibernate training"));

        System.out.println("BEFORE COMMIT");
        transaction.commit();

        entityManager.close();
        System.out.println(new Todo(UUID.randomUUID(), "conduct JPA training"));
    }
}
