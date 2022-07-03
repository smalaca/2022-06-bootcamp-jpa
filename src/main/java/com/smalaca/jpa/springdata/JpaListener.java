package com.smalaca.jpa.springdata;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class JpaListener {
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;

    public JpaListener(AddressRepository addressRepository, ProductRepository productRepository) {
        this.addressRepository = addressRepository;
        this.productRepository = productRepository;
    }

    @EventListener
    @Transactional
    public void test(ContextRefreshedEvent event) {
        products();
//        addresses();
    }

    private void products() {
        productRepository.save(new Product("Coca", "CocaCola", "drink", 123));
        productRepository.save(new Product("Sprite", "CocaCola", "drink", 42));
        productRepository.save(new Product("Fanta", "CocaCola", "drink", 12));
        productRepository.save(new Product("Pepsi", "Pepsi", "drink", 98));
        productRepository.save(new Product("7UP", "Pepsi", "drink", 67));
        productRepository.save(new Product("Mirinda", "Pepsi", "drink", 43));

        productRepository.findAll().forEach(System.out::println);
    }

    private void addresses() {
        addressRepository.save(new Address("Krakowska 3/2", "12345", "Kraków", "Polska"));
        addressRepository.save(new Address("Floriańska 13/42", "12345", "Kraków", "Polska"));
        addressRepository.save(new Address("Krakowska 67", "43212", "Warszawa", "Polska"));
        addressRepository.save(new Address("Krakowska 63", "43212", "Warszawa", "Polska"));
        addressRepository.save(new Address("Lubicz 7/7", "12345", "Kraków", "Polska"));
        addressRepository.save(new Address("Lubicz 7/7", "12345", "Gdynia", "Polska"));

        System.out.println("---- FIND ALL ----");
        addressRepository.findAll().forEach(System.out::println);
        System.out.println("---- FIND FOR KRAKÓW ----");
        addressRepository.findAllByCity("Kraków").forEach(System.out::println);
        System.out.println("---- FIND FOR WARSZAWA ----");
        addressRepository.findAllByCity("Warszawa").forEach(System.out::println);
        System.out.println("---- FIND FOR GDYNIA ----");
        addressRepository.findAllByCity("Gdynia").forEach(System.out::println);
        System.out.println("---- FIND FOR WARSZAWA OR LUBICZ 7/7 ----");
        addressRepository.findAllByCityOrStreet("Warszawa", "Lubicz 7/7").forEach(System.out::println);
        System.out.println("---- FIND FOR WARSZAWA AND Krakowska 63 ----");
        addressRepository.findAllByCityAndStreet("Warszawa", "Krakowska 63").forEach(System.out::println);
        System.out.println("---- KONIEC ----");
    }
}
