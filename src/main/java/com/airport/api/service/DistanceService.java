package com.airport.api.service;

import com.airport.api.dto.DistanceDTO;

public interface DistanceService {

    DistanceDTO findDistance(String destination, String Arrival);
}
