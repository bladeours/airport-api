package com.airport.api.service;

import com.airport.api.dto.AirportDTO;
import com.airport.api.dto.DistanceDTO;
import com.airport.api.model.Airport;

import java.util.List;

public interface AirportService {
    List<AirportDTO> findAll();

    AirportDTO findByCode(String code);

}
