package com.example.schedule.controller;


import com.example.schedule.dto.TripAddPersonDto;
import com.example.schedule.dto.TripCreateDto;
import com.example.schedule.service.TripService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/trip")
public class TripController {

    @Inject
    private TripService tripService;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createTrip(TripCreateDto tripCreateDto){
        return Response.created(URI.create("/trip")).entity(tripService.create(tripCreateDto)).build();
    }

    @GET
    @Path("/{tripId}")
    @Produces("application/json")
    public Response getTrip(@PathParam("tripId") Long tripId){
        return Response.ok(tripService.getTrip(tripId)).build();
    }

    @DELETE
    @Path("/{tripId}")
    @Produces("application/json")
    public Response delete(@PathParam("tripId") Long tripId){
        tripService.deleteById(tripId);
        return Response.ok().build();
    }

    @PUT
    @Path("/add/person")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(TripAddPersonDto tripAddPersonDto){
        return Response.ok(tripService.updateTrip(tripAddPersonDto)).build();
    }

    @GET
    @Path("/search/ship/{mmsi}")
    @Produces("application/json")
    public Response getTrips(@PathParam("mmsi") int mmsi){
        return Response.ok(tripService.getTripsByShip(mmsi)).build();
    }

    @GET
    @Path("/search/person/{ccnumber}")
    public Response getForPerson(@PathParam("ccnumber") int cc){
        return Response.ok(tripService.getTripByPerson(cc)).build();
    }
}


