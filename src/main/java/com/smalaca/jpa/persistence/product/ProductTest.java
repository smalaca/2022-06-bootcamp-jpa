package com.smalaca.jpa.persistence.product;

import com.smalaca.jpa.persistence.RepositoriesFactory;

import java.util.List;

public class ProductTest {

    private static final RepositoriesFactory FACTORY = RepositoriesFactory.create();

    public static void main(String[] args) {
        createProducts();
        System.out.println("----------------");

        findOneProduct();
        System.out.println("----------------");

        findAllProducts();
        System.out.println("----------------");

        deleteOneProduct();
        System.out.println("----------------");
        findAllProducts();

        FACTORY.close();
    }

    private static void deleteOneProduct() {
        FACTORY.productRepository().deleteById(1L);
    }

    private static void findAllProducts() {
        List<Product> products = FACTORY.productRepository().findAll();
        products.forEach(System.out::println);
    }

    private static void findOneProduct() {
        ProductRepository productRepositoryTwo = FACTORY.productRepository();
        System.out.println(productRepositoryTwo.findById(1L));
        System.out.println(productRepositoryTwo.findById(13L));
    }

    private static void createProducts() {
        ProductRepository productRepositoryOne = FACTORY.productRepository();
        productRepositoryOne.save(new Product(1L, "Tea"));
        productRepositoryOne.save(new Product(2L, "Coffee", "The best drink ever"));
        productRepositoryOne.save(new Product(3L, "Water", "Perfect for hot days"));
        productRepositoryOne.save(new Product(4L, "Milk"));
    }
}
