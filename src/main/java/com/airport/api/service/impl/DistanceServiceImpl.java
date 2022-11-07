package com.airport.api.service.impl;

import com.airport.api.dto.DistanceDTO;
import com.airport.api.model.Airport;
import com.airport.api.repository.AirportRepository;
import com.airport.api.service.AirportService;
import com.airport.api.service.DistanceService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DistanceServiceImpl implements DistanceService {
    private final AirportRepository airportRepository;


    public DistanceServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }


    @Override
    public DistanceDTO findDistance(String departure, String arrival) {

        Airport departureAirport = airportRepository.findByCode(departure);
        Airport arrivalAirport = airportRepository.findByCode(arrival);

        int distance;
        try{
            distance =  (int)distance(Double.parseDouble(departureAirport.getLatitude()),
                                    Double.parseDouble(departureAirport.getLongitude()),
                                    Double.parseDouble(arrivalAirport.getLatitude()),
                                    Double.parseDouble(arrivalAirport.getLongitude()));
        }catch (NullPointerException e){
            throw new NoSuchElementException();
        }
        return new DistanceDTO(departureAirport, arrivalAirport, distance);
    }

    public double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }


}
