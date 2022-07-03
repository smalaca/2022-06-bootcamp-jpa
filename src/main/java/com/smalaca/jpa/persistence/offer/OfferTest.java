package com.smalaca.jpa.persistence.offer;

import com.smalaca.jpa.persistence.RepositoriesFactory;
import com.smalaca.jpa.persistence.invoice.Invoice;
import com.smalaca.jpa.persistence.invoice.InvoiceRepository;

import java.util.List;
import java.util.UUID;

public class OfferTest {

    private static final RepositoriesFactory FACTORY = RepositoriesFactory.create();

    public static void main(String[] args) {
        createAll();
        findAllInvoices();
        findAllOffers();

        FACTORY.close();
    }

    private static void findAllInvoices() {
        InvoiceRepository repository = FACTORY.invoiceRepository();
        List<Invoice> found = repository.findAll();
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
        offerRepository.save(offerOne);
        Offer offerTwo = new Offer(UUID.randomUUID().toString());
        offerRepository.save(offerTwo);
        offerRepository.save(new Offer(UUID.randomUUID().toString()));

        InvoiceRepository invoiceRepository = FACTORY.invoiceRepository();
        invoiceRepository.save(new Invoice());

        Invoice invoiceOne = new Invoice();
        invoiceOne.add(offerOne);
        invoiceRepository.save(invoiceOne);

        Invoice invoiceTwo = new Invoice();
        invoiceTwo.add(offerTwo);
        invoiceRepository.save(invoiceTwo);
    }
}
