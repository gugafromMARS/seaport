package com.example.schedule.converter;

import com.example.schedule.dto.*;
import com.example.schedule.model.Trip;

import java.util.List;

public interface TripConverter {

    Trip fromCreateDto(TripCreateDto tripCreateDto, ShipDto shipDto);
    TripDto toDto(Trip trip);
    TripPersonDto toTripPersonDto(Trip trip);
    TripShipDto toTripShipDto(Trip trip);
    List<TripShipDto> fromListOfTrips(List<Trip> trips);
    List<TripPersonDto> fromCcOfPerson(List<Trip> trips);
}
