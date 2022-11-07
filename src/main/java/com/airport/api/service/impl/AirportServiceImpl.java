package com.airport.api.service.impl;

import com.airport.api.dto.AirportDTO;
import com.airport.api.dto.DistanceDTO;
import com.airport.api.model.Airport;
import com.airport.api.repository.AirportRepository;
import com.airport.api.service.AirportService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public List<AirportDTO> findAll() {
        return modelMapper.map(airportRepository.findAll(),
                new TypeToken<List<AirportDTO>>() {}.getType());
    }

    @Override
    public AirportDTO findByCode(String code) {
        try {
            return modelMapper.map(airportRepository.findByCode(code), AirportDTO.class);

        }catch (IllegalArgumentException e){
            throw new NoSuchElementException();
        }
    }




}
