package com.smalaca.jpa.persistence;

import com.smalaca.jpa.persistence.product.ProductRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RepositoriesFactory {
    private final EntityManagerFactory entityManagerFactory;

    private RepositoriesFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public static RepositoriesFactory create() {
        return new RepositoriesFactory(Persistence.createEntityManagerFactory("ToDo"));
    }

    public void close() {
        entityManagerFactory.close();
    }

    public ProductRepository productRepository() {
        return new ProductRepository(entityManagerFactory.createEntityManager());
    }
}
