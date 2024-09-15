package com.example.cargomanagement.converter;

import com.example.cargomanagement.dto.CargoCreateDto;
import com.example.cargomanagement.dto.CargoDto;
import com.example.cargomanagement.dto.ShipDto;
import com.example.cargomanagement.model.Cargo;

public interface CargoConverter {

    Cargo fromCreateDto(CargoCreateDto cargoCreateDto, ShipDto shipDto);
    CargoDto toDto(Cargo cargo);
}
