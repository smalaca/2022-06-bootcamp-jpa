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
        System.out.println("--------------");
        findAllProducts();
        System.out.println("--------------");
        findAllInvoiceItems();

        FACTORY.close();
    }

    private static void findAllProducts() {
        ProductRepository repository = FACTORY.productRepository();
        List<Product> found = repository.findAll();
        System.out.println("SIZE OF PRODUCTS: " + found.size());
        found.forEach(System.out::println);
    }

    private static void findAllInvoiceItems() {
        InvoiceItemRepository repository = FACTORY.invoiceItemRepository();
        List<InvoiceItem> found = repository.findAll();
        System.out.println("SIZE OF INVOICE ITEMS: " + found.size());
        found.forEach(System.out::println);
    }

    private static void createAll() {
        ProductRepository productRepositoryOne = FACTORY.productRepository();
        Product water = new Product("Water", BigDecimal.valueOf(123));
        productRepositoryOne.save(water);
        Product tea = new Product("Tea", BigDecimal.valueOf(123));
        productRepositoryOne.save(tea);
        Product coffee = new Product("Coffee", BigDecimal.valueOf(123));
        productRepositoryOne.save(coffee);

        InvoiceItemRepository invoiceItemRepositoryOne = FACTORY.invoiceItemRepository();
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItemRepositoryOne.save(invoiceItem);
        InvoiceItem invoiceItemForTea = new InvoiceItem(tea, 1);
        invoiceItemRepositoryOne.save(invoiceItemForTea);
        InvoiceItem invoiceItemForWater = new InvoiceItem(water, 1);
        invoiceItemRepositoryOne.save(invoiceItemForWater);

        invoiceItemRepositoryOne.close();
        productRepositoryOne.close();

        ProductRepository productRepositoryTwo = FACTORY.productRepository();
        InvoiceItemRepository invoiceItemRepositoryTwo = FACTORY.invoiceItemRepository();

        invoiceItemRepositoryTwo.deleteById(invoiceItemForWater.getId());
        invoiceItemRepositoryTwo.deleteById(invoiceItem.getId());
        productRepositoryTwo.deleteById(coffee.getId());
//        productRepositoryTwo.deleteById(tea.getId());
    }
}
