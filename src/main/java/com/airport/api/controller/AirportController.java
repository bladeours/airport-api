package com.airport.api.controller;

import com.airport.api.model.Airport;
import com.airport.api.service.AirportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/airports")
    public List<Airport> findAll(){
        return airportService.findAll();
    }

    @GetMapping("/airport/{code}")
    public Airport findByCode(@PathVariable String code){
        return airportService.findByCode(code.toUpperCase());
    }

}
