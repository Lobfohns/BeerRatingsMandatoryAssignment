package com.example.beertasting.repositories;

import com.example.beertasting.models.Beer;
import org.springframework.data.repository.CrudRepository;

public interface BeerRepository extends CrudRepository<Beer, Long > {
}
