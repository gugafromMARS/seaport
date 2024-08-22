package com.example.shipmanagement.controller;


import com.example.shipmanagement.dto.ShipCreateDto;
import com.example.shipmanagement.service.ShipService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/ship")
public class ShipController {

    @Inject
    private ShipService service;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(ShipCreateDto shipCreateDto){
        return Response.created(URI.create("/ship")).entity(service.createShip(shipCreateDto)).build();
    }

    @GET
    @Path("/mmsi/{mmsi}")
    @Produces("application/json")
    public Response get(@PathParam("mmsi") int mmsi){
        return Response.ok(service.getShipByMMSI(mmsi)).build();
    }

}
