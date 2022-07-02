package com.smalaca.jpa.persistence.product;

import com.smalaca.jpa.persistence.RepositoriesFactory;

import java.util.List;
import java.util.UUID;

public class ProductTest {

    private static final RepositoriesFactory FACTORY = RepositoriesFactory.create();

    public static void main(String[] args) {
        UUID productIdOne = createProducts();
        findOneProduct(productIdOne);
        findAllProducts();

        FACTORY.close();
    }

    private static void findAllProducts() {
        List<Product> products = FACTORY.productRepository().findAll();
        products.forEach(System.out::println);
    }

    private static void findOneProduct(UUID productIdOne) {
        ProductRepository productRepositoryTwo = FACTORY.productRepository();
        System.out.println(productRepositoryTwo.findById(productIdOne));
        System.out.println(productRepositoryTwo.findById(UUID.randomUUID()));
    }

    private static UUID createProducts() {
        ProductRepository productRepositoryOne = FACTORY.productRepository();
        UUID productIdOne = UUID.randomUUID();
        productRepositoryOne.save(new Product(productIdOne, "Tea"));
        productRepositoryOne.save(new Product(UUID.randomUUID(), "Coffee", "The best drink ever"));
        productRepositoryOne.save(new Product(UUID.randomUUID(), "Water", "Perfect for hot days"));
        productRepositoryOne.save(new Product(UUID.randomUUID(), "Milk"));
        return productIdOne;
    }
}
