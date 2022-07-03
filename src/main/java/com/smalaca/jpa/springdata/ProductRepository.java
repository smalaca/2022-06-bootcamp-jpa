package com.smalaca.jpa.springdata;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {
    List<Product> findAllByManufacturer(String manufacturer);

    Optional<Product> findOneByName(String name);

    List<Product> findAllByPriceBetween(int min, int max);
}
