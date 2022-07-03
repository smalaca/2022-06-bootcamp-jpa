package com.smalaca.jpa.persistence.invoiceitem;

import com.smalaca.jpa.persistence.RepositoriesFactory;
import com.smalaca.jpa.persistence.product.Product;
import com.smalaca.jpa.persistence.product.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

public class InvoiceItemTest {

    private static final RepositoriesFactory FACTORY = RepositoriesFactory.create();

    public static void main(String[] args) {
        createAll();
        findAllProducts();
        findAllOfferItems();

        FACTORY.close();
    }

    private static void findAllProducts() {
        ProductRepository repository = FACTORY.productRepository();
        List<Product> found = repository.findAll();
        found.forEach(System.out::println);
    }

    private static void findAllOfferItems() {
        InvoiceItemRepository repository = FACTORY.offerItemRepository();
        List<InvoiceItem> found = repository.findAll();
        found.forEach(System.out::println);
    }

    private static void createAll() {
        ProductRepository productRepository = FACTORY.productRepository();
        Product water = new Product("Water", BigDecimal.valueOf(123));
        productRepository.save(water);
        Product tea = new Product("Tea", BigDecimal.valueOf(123));
        productRepository.save(tea);
        Product coffee = new Product("Coffee", BigDecimal.valueOf(123));
        productRepository.save(coffee);

        InvoiceItemRepository invoiceItemRepository = FACTORY.offerItemRepository();
        invoiceItemRepository.save(new InvoiceItem(coffee, 13));
        invoiceItemRepository.save(new InvoiceItem(tea, 1));
        invoiceItemRepository.save(new InvoiceItem(water, 1));
    }
}
