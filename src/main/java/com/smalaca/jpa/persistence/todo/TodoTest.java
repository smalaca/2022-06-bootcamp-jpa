package com.smalaca.jpa.persistence.todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.UUID;

public class TodoTest {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ToDo");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Todo todo = new Todo(UUID.randomUUID(), "conduct JPA training");
        entityManager.persist(todo);

        entityManager.getTransaction().commit();

        entityManager.close();
        System.out.println(todo);
    }
}
