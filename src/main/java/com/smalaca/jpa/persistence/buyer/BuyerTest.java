package com.smalaca.jpa.persistence.buyer;

import com.smalaca.jpa.persistence.RepositoriesFactory;
import com.smalaca.jpa.persistence.contactdetails.ContactDetails;

public class BuyerTest {
    private static final RepositoriesFactory FACTORY = RepositoriesFactory.create();

    public static void main(String[] args) {
        createBuyers();
        findAll();

        FACTORY.close();
    }

    private static void findAll() {
        BuyerRepository buyerRepository = FACTORY.buyerRepository();
        buyerRepository.findAll().forEach(System.out::println);
    }

    private static void createBuyers() {
        BuyerRepository buyerRepository = FACTORY.buyerRepository();
        buyerRepository.save(new Buyer(new ContactDetails("pparker", "111111111", "peter.parker@marvel.com")));
        buyerRepository.save(new Buyer(new ContactDetails("srogers", "123456789", "captain.america@marvel.com")));
        buyerRepository.save(new Buyer(new ContactDetails("carol.d4nv3rs", "987654321", "captain@marvel.com")));
    }
}
