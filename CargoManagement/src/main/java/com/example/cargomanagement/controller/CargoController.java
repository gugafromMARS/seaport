package com.example.cargomanagement.controller;


import com.example.cargomanagement.dto.CargoCreateDto;
import com.example.cargomanagement.service.CargoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.UUID;

@Path("/cargo")
public class CargoController {

    @Inject
    private CargoService cargoService;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(CargoCreateDto cargoCreateDto){
        return Response.created(URI.create("/cargo"))
                .entity(cargoService.createCargo(cargoCreateDto)).build();
    }

    @GET
    @Path("/ship/{mmsi}")
    @Produces("application/json")
    public Response getCargoByShip(@PathParam("mmsi") int mmsi){
        return Response.ok(cargoService.getByShip(mmsi)).build();
    }

    @GET
    @Path("/{cargoNumber}")
    @Produces("application/json")
    public Response getCargoByCargoNumber(@PathParam("cargoNumber")UUID cargoNumber){
        return Response.ok(cargoService.getCargoByUUId(cargoNumber)).build();
    }

    @GET
    @Path("/cargotype/{type}")
    @Produces("application/json")
    public Response getCargoByType(@PathParam("type") String type){
        return Response.ok(cargoService.getByType(type)).build();
    }
}
