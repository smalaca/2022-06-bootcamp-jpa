package com.smalaca.jpa.persistence.invoice;

import com.smalaca.jpa.persistence.RepositoriesFactory;

import java.util.List;

public class InvoiceTest {

    private static final RepositoriesFactory FACTORY = RepositoriesFactory.create();

    public static void main(String[] args) {
        createInvoices();
        findAll();

        FACTORY.close();
    }

    private static void findAll() {
        InvoiceRepository repository = FACTORY.invoiceRepository();
        List<Invoice> invoices = repository.findAll();
        invoices.forEach(System.out::println);
    }

    private static void createInvoices() {
        InvoiceRepository repository = FACTORY.invoiceRepository();
        repository.save(new Invoice());
        Invoice invoiceOne = new Invoice();
        invoiceOne.sent();
        repository.save(invoiceOne);
        Invoice invoiceTwo = new Invoice();
        invoiceTwo.payed();
        repository.save(invoiceTwo);
    }
}
