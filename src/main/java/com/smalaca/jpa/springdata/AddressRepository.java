package com.smalaca.jpa.springdata;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {
    List<Address> findAllByCity(String city);

    List<Address> findAllByCityOrStreet(String city, String street);
}
