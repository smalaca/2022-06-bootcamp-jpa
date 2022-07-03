package com.smalaca.jpa.persistence.invoice;

import com.smalaca.jpa.persistence.RepositoriesFactory;
import com.smalaca.jpa.persistence.invoiceitem.InvoiceItem;
import com.smalaca.jpa.persistence.invoiceitem.InvoiceItemRepository;
import com.smalaca.jpa.persistence.product.Product;
import com.smalaca.jpa.persistence.product.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

public class InvoiceTest {

    private static final RepositoriesFactory FACTORY = RepositoriesFactory.create();

    public static void main(String[] args) {
        createInvoices();
        System.out.println("------------------------");
        findAllInvoices();
        System.out.println("------------------------");
        findAllInvoiceItems();

        FACTORY.close();
    }

    private static void findAllInvoices() {
        InvoiceRepository repository = FACTORY.invoiceRepository();
        List<Invoice> invoices = repository.findAll();
        invoices.forEach(System.out::println);
    }

    private static void findAllInvoiceItems() {
        InvoiceItemRepository repository = FACTORY.invoiceItemRepository();
        List<InvoiceItem> found = repository.findAll();
        found.forEach(System.out::println);
    }

    private static void createInvoices() {
        ProductRepository productRepositoryOne = FACTORY.productRepository();
        Product water = new Product("Water", BigDecimal.valueOf(123));
        productRepositoryOne.save(water);
        Product tea = new Product("Tea", BigDecimal.valueOf(123));
        productRepositoryOne.save(tea);
        Product coffee = new Product("Coffee", BigDecimal.valueOf(123));
        productRepositoryOne.save(coffee);

        InvoiceRepository repository = FACTORY.invoiceRepository();
        repository.save(new Invoice());

        Invoice invoiceOne = new Invoice();
        invoiceOne.add(new InvoiceItem());
        invoiceOne.add(new InvoiceItem(tea, 1));
        repository.save(invoiceOne);

        Invoice invoiceTwo = new Invoice();
        invoiceTwo.add(new InvoiceItem(water, 1));
        repository.save(invoiceTwo);
    }
}
