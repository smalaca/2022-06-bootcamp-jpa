package com.smalaca.jpa.persistence.seller;

import com.smalaca.jpa.persistence.RepositoriesFactory;
import com.smalaca.jpa.persistence.contactdetails.ContactDetails;

public class SellerTest {
    private static final RepositoriesFactory FACTORY = RepositoriesFactory.create();

    public static void main(String[] args) {
        createBuyers();
        findAll();

        FACTORY.close();
    }

    private static void findAll() {
        SellerRepository sellerRepository = FACTORY.sellerRepository();
        sellerRepository.findAll().forEach(System.out::println);
    }

    private static void createBuyers() {
        SellerRepository sellerRepository = FACTORY.sellerRepository();
        sellerRepository.save(new Seller(new ContactDetails("pparker", "111111111", "peter.parker@marvel.com")));
        sellerRepository.save(new Seller(new ContactDetails("srogers", "123456789", "captain.america@marvel.com")));
        sellerRepository.save(new Seller(new ContactDetails("carol.d4nv3rs", "987654321", "captain@marvel.com")));
    }
}
