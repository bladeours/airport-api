package com.airport.api.repository;

import com.airport.api.model.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends MongoRepository<Airport, String> {
    Airport findByCode(String code);

    @Override
    List<Airport> findAll();


}
