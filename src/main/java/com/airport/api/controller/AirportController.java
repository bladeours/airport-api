package com.airport.api.controller;

import com.airport.api.dto.AirportDTO;
import com.airport.api.model.Airport;
import com.airport.api.service.AirportService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/")
public class AirportController {
    private final AirportService airportService;
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/airports")
    public List<AirportDTO> findAll(){
        return airportService.findAll();
    }

    @GetMapping("/airport/{code}")
    public AirportDTO findByCode(@PathVariable String code){
        return airportService.findByCode(code.toUpperCase());
    }

}
