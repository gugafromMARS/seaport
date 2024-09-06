package com.example.schedule.converter;


import com.example.schedule.dto.*;
import com.example.schedule.model.Trip;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class TripConverter {

    public Trip fromCreateDto(TripCreateDto tripCreateDto, ShipDto shipDto){
        return Trip.builder()
                .withDate(tripCreateDto.getDate())
                .withShip(shipDto)
                .withPersons()
                .build();
    }

    public TripDto toDto(Trip trip){
        return TripDto.builder()
                .withId(trip.getId())
                .withShipId(trip.getShipDto())
                .withDate(trip.getDate())
                .withPeople(trip.getPersonList())
                .build();
    }

    public TripPersonDto toTripPersonDto(Trip trip){
        return TripPersonDto.builder()
                .withId(trip.getId())
                .withDate(trip.getDate())
                .withShipId(trip.getShipDto())
                .build();
    }

    public TripShipDto toTripShipDto(Trip trip){
        return TripShipDto.builder()
                .withId(trip.getId())
                .withDate(trip.getDate())
                .withPeople(trip.getPersonList())
                .build();
    }

    public List<TripShipDto> fromListOfTrips(List<Trip> trips) {
        return trips.stream().map(trip -> toTripShipDto(trip)).collect(Collectors.toList());
    }

    public List<TripPersonDto> fromCcOfPerson(List<Trip> trips){
        return trips.stream().map(trip -> toTripPersonDto(trip)).collect(Collectors.toList());
    }


}
