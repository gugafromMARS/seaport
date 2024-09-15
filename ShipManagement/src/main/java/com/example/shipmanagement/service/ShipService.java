package com.example.shipmanagement.service;


import com.example.shipmanagement.converter.ShipConverterImp;
import com.example.shipmanagement.dto.ShipCreateDto;
import com.example.shipmanagement.dto.ShipDto;
import com.example.shipmanagement.model.Ship;
import com.example.shipmanagement.repository.ShipRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Stateless
public class ShipService {

    @EJB
    private ShipConverterImp shipConverterImp;
    @EJB
    private ShipRepository shipRepository;
    public ShipService(ShipConverterImp shipConverterImp, ShipRepository shipRepository) {
        this.shipConverterImp = shipConverterImp;
        this.shipRepository = shipRepository;
    }

    public ShipService() {
    }

    public ShipDto createShip(ShipCreateDto shipCreateDto) {
        Ship existingShip = shipRepository.findByMMSI(shipCreateDto.getMmsi());
        if(existingShip != null){
            throw new WebApplicationException("Ship already registered", Response.Status.BAD_REQUEST);
        }
        existingShip = shipConverterImp.fromCreateDto(shipCreateDto);
        shipRepository.save(existingShip);
        return shipConverterImp.toDto(existingShip);
    }


    public ShipDto getShipByMMSI(int mmsi) {
        Ship existingShip = shipRepository.findByMMSI(mmsi);
        if(existingShip == null){
            throw  new WebApplicationException("Ship not found", Response.Status.NOT_FOUND);
        }
        return shipConverterImp.toDto(existingShip);
    }


}
