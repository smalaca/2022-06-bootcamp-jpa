package com.smalaca.jpa.springdata;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class JpaListener {
    private final AddressRepository addressRepository;

    public JpaListener(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @EventListener
    @Transactional
    public void test(ContextRefreshedEvent event) {
        addressRepository.save(new Address("Krakowska 3/2", "12345", "Kraków", "Polska"));
        addressRepository.save(new Address("Floriańska 13/42", "12345", "Kraków", "Polska"));
        addressRepository.save(new Address("Krakowska 67", "43212", "Warszawa", "Polska"));
        addressRepository.save(new Address("Krakowska 67", "43212", "Warszawa", "Polska"));
        addressRepository.save(new Address("Lubicz 7/7", "12345", "Kraków", "Polska"));

        System.out.println("---- FIND ALL ----");
        addressRepository.findAll().forEach(System.out::println);
        System.out.println("---- FIND FOR KRAKÓW ----");
        addressRepository.findAllByCity("Kraków").forEach(System.out::println);
        System.out.println("---- FIND FOR WARSZAWA ----");
        addressRepository.findAllByCity("Warszawa").forEach(System.out::println);
        System.out.println("---- FIND FOR GDYNIA ----");
        addressRepository.findAllByCity("Gdynia").forEach(System.out::println);
        System.out.println("---- KONIEC ----");
    }
}
