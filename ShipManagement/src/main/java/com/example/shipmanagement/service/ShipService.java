package com.example.shipmanagement.service;


import com.example.shipmanagement.converter.ShipConverter;
import com.example.shipmanagement.dto.ShipCreateDto;
import com.example.shipmanagement.dto.ShipDto;
import com.example.shipmanagement.model.Ship;
import com.example.shipmanagement.repository.ShipRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class ShipService {

    @Inject
    private ShipConverter shipConverter;
    @Inject
    private ShipRepository shipRepository;

    public ShipDto createShip(ShipCreateDto shipCreateDto) {
        Ship existingShip = shipRepository.findByMMSI(shipCreateDto.getMmsi());
        if(existingShip != null){
            throw new WebApplicationException("Ship already registered", Response.Status.BAD_REQUEST);
        }
        existingShip = shipConverter.fromCreateDto(shipCreateDto);
        shipRepository.save(existingShip);
        return shipConverter.toDto(existingShip);
    }


    public ShipDto getShipByMMSI(int mmsi) {
        Ship existingShip = shipRepository.findByMMSI(mmsi);
        if(existingShip == null){
            throw  new WebApplicationException("Ship not found", Response.Status.NOT_FOUND);
        }
        return shipConverter.toDto(existingShip);
    }


}
