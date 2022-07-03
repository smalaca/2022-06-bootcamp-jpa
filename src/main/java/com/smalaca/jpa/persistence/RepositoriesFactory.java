package com.smalaca.jpa.persistence;

import com.smalaca.jpa.persistence.basket.BasketRepository;
import com.smalaca.jpa.persistence.buyer.BuyerRepository;
import com.smalaca.jpa.persistence.invoice.InvoiceRepository;
import com.smalaca.jpa.persistence.product.ProductRepository;
import com.smalaca.jpa.persistence.seller.SellerRepository;

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

    public InvoiceRepository invoiceRepository() {
        return new InvoiceRepository(entityManagerFactory.createEntityManager());
    }

    public BuyerRepository buyerRepository() {
        return new BuyerRepository(entityManagerFactory.createEntityManager());
    }

    public SellerRepository sellerRepository() {
        return new SellerRepository(entityManagerFactory.createEntityManager());
    }

    public BasketRepository basketRepository() {
        return new BasketRepository(entityManagerFactory.createEntityManager());
    }
}
