package com.example.shipmanagement.converter;


import com.example.shipmanagement.dto.ShipCreateDto;
import com.example.shipmanagement.dto.ShipDto;
import com.example.shipmanagement.model.Ship;

import javax.ejb.Stateless;



@Stateless
public class ShipConverter {


    public Ship fromCreateDto (ShipCreateDto shipCreateDto){
        return Ship.builder()
                .withName(shipCreateDto.getName())
                .withRadioNumber(shipCreateDto.getRadioNumber())
                .withMMSI(shipCreateDto.getMmsi())
                .withShipType(shipCreateDto.getShipType())
                .withFlag(shipCreateDto.getFlag())
                .withOwnerEmail(shipCreateDto.getOwnerEmail())
                .build();
    }

    public ShipDto toDto(Ship ship){
        return ShipDto.builder()
                .withName(ship.getName())
                .withRadioNumber(ship.getRadioNumber())
                .withMMSI(ship.getMmsi())
                .withShipType(ship.getShipType())
                .withFlag(ship.getFlag())
                .withOwnerEmail(ship.getOwnerEmail())
                .build();
    }
}
