package com.smalaca.jpa.persistence.basket;

import com.smalaca.jpa.persistence.RepositoriesFactory;

public class BasketTest {
    private static final RepositoriesFactory FACTORY = RepositoriesFactory.create();

    public static void main(String[] args) {
        createBaskets();
        findAll();

        FACTORY.close();
    }

    private static void findAll() {
        BasketRepository basketRepository = FACTORY.basketRepository();
        basketRepository.findAll().forEach(System.out::println);
    }

    private static void createBaskets() {
        BasketRepository basketRepository = FACTORY.basketRepository();

        Basket basketOne = new Basket();
        basketOne.addProducts(13L, 13);
        basketOne.addProducts(2L, 42);
        basketRepository.save(basketOne);

        Basket basketTwo = new Basket();
        basketTwo.addProducts(13L, 11);
        basketTwo.addProducts(2L, 9);
        basketTwo.addProducts(22L, 3);
        basketTwo.addProducts(12L, 91);
        basketRepository.save(basketTwo);

        Basket basketThree = new Basket();
        basketRepository.save(basketThree);
    }
}
