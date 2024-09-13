package com.example.cargomanagement.converter;


import com.example.cargomanagement.dto.CargoCreateDto;
import com.example.cargomanagement.dto.CargoDto;
import com.example.cargomanagement.dto.ShipDto;
import com.example.cargomanagement.model.Cargo;
import com.example.cargomanagement.model.DateType;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

@Stateless
public class CargoConverter {

    public Cargo fromCreateDto(CargoCreateDto cargoCreateDto, ShipDto shipDto){
        return Cargo.builder()
                .withWeight(cargoCreateDto.getWeight())
                .withVolume(cargoCreateDto.getVolume())
                .withCargoType(cargoCreateDto.getCargoType())
                .withOrigin(cargoCreateDto.getOrigin())
                .withCargoNumber(cargoCreateDto.getUuid())
                .withDate(DateType.ARRIVAL, cargoCreateDto.getEstimatedArrivalDate())
                .withDate(DateType.DEPARTURE, cargoCreateDto.getEstimatedDepartureDate())
                .withShip(shipDto)
                .build();
    }

    public CargoDto toDto(Cargo cargo){
        return CargoDto.builder()
                .withId(cargo.getId())
                .withWeight(cargo.getWeight())
                .withVolume(cargo.getVolume())
                .withCargoType(cargo.getCargoType())
                .withOrigin(cargo.getOrigin())
                .withArrivalDate(cargo.getEstimatedArrivalDate())
                .withDepartureDate(cargo.getEstimatedDepartureDate())
                .withShip(cargo.getShipDto())
                .withUUID(cargo.getCargoNumber())
                .build();
    }
}
