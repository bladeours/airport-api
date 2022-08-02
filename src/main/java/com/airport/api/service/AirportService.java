package com.airport.api.service;

import com.airport.api.model.Airport;

import java.util.List;

public interface AirportService {
    List<Airport> findAll();
    Airport findByCode(String code);
}
