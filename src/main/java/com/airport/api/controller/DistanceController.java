package com.airport.api.controller;


import com.airport.api.dto.DistanceDTO;
import com.airport.api.service.DistanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distance")
public class DistanceController {

    private final DistanceService distanceService;

    public DistanceController(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @GetMapping("/{departure}/{arrival}")
    public DistanceDTO findDistance(@PathVariable String departure, @PathVariable String arrival){
        return distanceService.findDistance(departure.toUpperCase(), arrival.toUpperCase());
    }
}
