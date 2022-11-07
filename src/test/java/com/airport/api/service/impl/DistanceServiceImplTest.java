package com.airport.api.service.impl;

import com.airport.api.repository.AirportRepository;
import com.airport.api.service.DistanceService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DistanceServiceImplTest {
    @Mock
    AirportRepository airportRepository;
    DistanceServiceImpl distanceService;

    @BeforeEach
    void setUp() {
        distanceService = new DistanceServiceImpl(airportRepository);
    }

    @Test
    public void findDistance_whenAirportDoesNotExists_ThrowException(){
        when(airportRepository.findByCode(any())).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> distanceService.findDistance("test", "test"));
    }

    @Test
    public void distance_shouldCalculateProperly(){
        double distance = distanceService.distance(52.16569901,20.96710014, 31.53549957,  -84.19450378 );
        assertThat(distance).isCloseTo(8223.321916939329, Assertions.offset(0.1d));
    }
}