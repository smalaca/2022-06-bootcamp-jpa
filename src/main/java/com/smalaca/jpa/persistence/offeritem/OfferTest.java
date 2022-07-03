package com.smalaca.jpa.persistence.offeritem;

import com.smalaca.jpa.persistence.RepositoriesFactory;
import com.smalaca.jpa.persistence.offer.Offer;
import com.smalaca.jpa.persistence.offer.OfferRepository;

import java.util.List;
import java.util.UUID;

public class OfferTest {

    private static final RepositoriesFactory FACTORY = RepositoriesFactory.create();

    public static void main(String[] args) {
        createAll();
        findAllOfferItems();
        findAllOffers();

        FACTORY.close();
    }

    private static void findAllOfferItems() {
        OfferItemRepository repository = FACTORY.offerItemRepository();
        List<OfferItem> found = repository.findAll();
        found.forEach(System.out::println);
    }

    private static void findAllOffers() {
        OfferRepository repository = FACTORY.offerRepository();
        List<Offer> found = repository.findAll();
        found.forEach(System.out::println);
    }

    private static void createAll() {
        OfferRepository offerRepository = FACTORY.offerRepository();
        Offer offerOne = new Offer(UUID.randomUUID().toString());
        offerOne.add(new OfferItem(UUID.randomUUID(), 13));
        offerOne.add(new OfferItem(UUID.randomUUID(), 42));
        offerOne.add(new OfferItem(UUID.randomUUID(), 7));
        offerRepository.save(offerOne);
        Offer offerTwo = new Offer(UUID.randomUUID().toString());
        offerTwo.add(new OfferItem(UUID.randomUUID(), 17));
        offerTwo.add(new OfferItem(UUID.randomUUID(), 71));
        offerRepository.save(offerTwo);
        offerRepository.save(new Offer(UUID.randomUUID().toString()));
    }
}
