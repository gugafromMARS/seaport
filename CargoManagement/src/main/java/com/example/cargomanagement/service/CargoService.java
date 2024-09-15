package com.example.cargomanagement.service;


import com.example.cargomanagement.converter.CargoConverter;
import com.example.cargomanagement.converter.CargoConverterImp;
import com.example.cargomanagement.dto.CargoCreateDto;
import com.example.cargomanagement.dto.CargoDto;
import com.example.cargomanagement.dto.ShipDto;
import com.example.cargomanagement.model.Cargo;
import com.example.cargomanagement.repository.CargoRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Stateless
public class CargoService {

    @EJB
    private CargoRepository cargoRepository;
    @EJB
    private CargoConverter converter;

    public CargoService(CargoRepository cargoRepository, CargoConverter converter) {
        this.cargoRepository = cargoRepository;
        this.converter = converter;
    }

    public CargoService() {
    }

    public CargoDto createCargo(CargoCreateDto cargoCreateDto) {
        Cargo existingCargo = cargoRepository.getCargoByUUID(cargoCreateDto.getUuid());
        if(existingCargo != null){
            throw new WebApplicationException("Cargo already exists.", Response.Status.BAD_REQUEST);
        }
        existingCargo = converter.fromCreateDto(cargoCreateDto, getShip(cargoCreateDto.getMmsi()));
        cargoRepository.save(existingCargo);
        return converter.toDto(existingCargo);
    }

    private ShipDto getShip(int mmsi){
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/ShipManagement-1.0-SNAPSHOT/api/ship/mmsi/" + mmsi);
        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();
        if(response.getStatus() != 200){
            throw new WebApplicationException("Ship not found", Response.Status.NOT_FOUND);
        }
        return response.readEntity(ShipDto.class);
    }
    public List<CargoDto> getByShip(int mmsi) {
        return cargoRepository.getCargoByShip(mmsi).stream().map(cargo -> converter.toDto(cargo)).collect(Collectors.toList());
    }

    public CargoDto getCargoByUUId(UUID uuid) {
        return converter.toDto(cargoRepository.getCargoByUUID(uuid));
    }

    public List<CargoDto> getByType(String type) {
        return cargoRepository.getCargoByCargoType(type).stream().map(cargo -> converter.toDto(cargo)).collect(Collectors.toList());
    }
}
