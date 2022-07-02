package com.smalaca.jpa.persistence.todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.UUID;

public class TodoTest {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ToDo");
        EntityManager entityManagerOne = factory.createEntityManager();

        EntityTransaction transactionOne = entityManagerOne.getTransaction();

        transactionOne.begin();
        UUID todoIdOne = UUID.randomUUID();
        entityManagerOne.persist(new Todo(todoIdOne, "conduct JPA training"));
        entityManagerOne.persist(new Todo(UUID.randomUUID(), "conduct ORM training"));
        entityManagerOne.persist(new Todo(UUID.randomUUID(), "conduct Hibernate training"));

        Todo foundInPersistenceContext = entityManagerOne.find(Todo.class, todoIdOne);
        System.out.println(foundInPersistenceContext);
        transactionOne.commit();
        entityManagerOne.close();

        EntityManager entityManagerTwo = factory.createEntityManager();

        Todo found = entityManagerTwo.find(Todo.class, todoIdOne);
        System.out.println(found);

        entityManagerTwo.close();
    }
}
