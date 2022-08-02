package com.airport.api.dto;

import com.airport.api.model.Airport;

public class DistanceDTO {

    private Airport departure;
    private Airport arrival;
    private int distance_km;


    public DistanceDTO() {
    }

    public DistanceDTO(Airport destination, Airport arrival, int distance_km) {
        this.departure = destination;
        this.arrival = arrival;
        this.distance_km = distance_km;
    }

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    public void setArrival(Airport arrival) {
        this.arrival = arrival;
    }

    public int getDistance_km() {
        return distance_km;
    }

    public void setDistance_km(int distance_km) {
        this.distance_km = distance_km;
    }

    @Override
    public String toString() {
        return "airportDistanceDTO{" +
                "destination=" + departure +
                ", arrival=" + arrival +
                ", distance=" + distance_km +
                '}';
    }
}
