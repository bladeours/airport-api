package com.airport.api.service.impl;

import com.airport.api.repository.AirportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AirportServiceImplTest {
    @Mock
    AirportRepository airportRepository;
    AirportServiceImpl airportService;

    @BeforeEach
    void setUp() {
        airportService = new AirportServiceImpl(airportRepository);
    }

    @Test
    public void findByCode_whenAirportDoesNotExists_ThrowException(){
        when(airportRepository.findByCode(any())).thenReturn(null);
        assertThrows(NoSuchElementException.class, () -> airportService.findByCode("test"));
    }
}