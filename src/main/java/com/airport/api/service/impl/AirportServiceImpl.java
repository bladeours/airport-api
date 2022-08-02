package com.airport.api.service.impl;

import com.airport.api.model.Airport;
import com.airport.api.repository.AirportRepository;
import com.airport.api.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    @Override
    public Airport findByCode(String code) {
        return airportRepository.findByCode(code);
    }
}
