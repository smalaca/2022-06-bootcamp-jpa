package com.smalaca.jpa.persistence.product;

import com.smalaca.jpa.persistence.RepositoriesFactory;

import java.math.BigDecimal;
import java.util.List;

public class ProductTest {
    private static final RepositoriesFactory FACTORY = RepositoriesFactory.create();

    public static void main(String[] args) {
        Long id = createProducts();
        System.out.println("----------------");

        findOneProduct(id);
        System.out.println("----------------");

        updateOneProduct(id);
        System.out.println("----------------");

        findAllProducts();
        System.out.println("----------------");

        deleteOneProduct(id);
        System.out.println("----------------");

        findAllProducts();
        System.out.println("----------------");

        findAllProductsWithCategories();

        FACTORY.close();
    }

    private static void updateOneProduct(Long id) {
        ProductRepository repository = FACTORY.productRepository();
        Product product = repository.findById(id);
        product.updateDescription("You can drink that in many ways");
        repository.update(product);
    }

    private static void deleteOneProduct(Long id) {
        FACTORY.productRepository().deleteById(id);
    }

    private static void findAllProducts() {
        List<Product> products = FACTORY.productRepository().findAll();
        products.forEach(System.out::println);
    }

    private static void findAllProductsWithCategories() {
        List<Product> products = FACTORY.productRepository().findAllProductsWithCategories();
        products.forEach(System.out::println);
    }

    private static void findOneProduct(Long id) {
        ProductRepository repository = FACTORY.productRepository();
        System.out.println(repository.findById(id));
        System.out.println(repository.findById(13L));
    }

    private static Long createProducts() {
        ProductRepository repository = FACTORY.productRepository();
        repository.save(new Product("Coffee", BigDecimal.valueOf(13), "The best drink ever"));
        repository.save(new Product("Water", BigDecimal.valueOf(12.98), "Perfect for hot days. It does not matter if this is a weekend or not."));
        repository.save(new Product("Milk", BigDecimal.valueOf(42)));

        Product productWithCategories = new Product("Spider-Man Comic Book #13", BigDecimal.valueOf(13.22));
        productWithCategories.addCategory("Reading");
        productWithCategories.addCategory("Comic Book");
        productWithCategories.addCategory("Spider-Man");
        repository.save(productWithCategories);

        return repository.save(new Product("Tea", BigDecimal.valueOf(123.45)));
    }
}
