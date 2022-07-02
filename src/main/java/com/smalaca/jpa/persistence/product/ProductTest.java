package com.smalaca.jpa.persistence.product;

import com.smalaca.jpa.persistence.RepositoriesFactory;

import java.util.UUID;

public class ProductTest {

    private static final RepositoriesFactory FACTORY = RepositoriesFactory.create();

    public static void main(String[] args) {
        ProductRepository productRepositoryOne = FACTORY.productRepository();

        UUID productIdOne = UUID.randomUUID();
        productRepositoryOne.save(new Product(productIdOne, "Tea"));
        UUID productIdTwo = UUID.randomUUID();
        productRepositoryOne.save(new Product(productIdTwo, "Coffee", "The best drink ever"));

        ProductRepository productRepositoryTwo = FACTORY.productRepository();

        System.out.println(productRepositoryTwo.findById(productIdOne));
        System.out.println(productRepositoryTwo.findById(productIdTwo));
        System.out.println(productRepositoryTwo.findById(UUID.randomUUID()));

        FACTORY.close();
    }
}
