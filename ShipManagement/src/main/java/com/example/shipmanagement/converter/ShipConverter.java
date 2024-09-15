package com.example.shipmanagement.converter;

import com.example.shipmanagement.dto.ShipCreateDto;
import com.example.shipmanagement.dto.ShipDto;
import com.example.shipmanagement.model.Ship;

public interface ShipConverter {

    Ship fromCreateDto(ShipCreateDto shipCreateDto);
    ShipDto toDto(Ship ship);
}
