package com.example.accesscontrol.controller;


import com.example.accesscontrol.dto.AccessCreateDto;
import com.example.accesscontrol.service.AccessService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;


@Path("/access")
public class AccessController {

    @EJB
    private AccessService accessService;

    public AccessController(AccessService accessService) {
        this.accessService = accessService;
    }
    public AccessController() {
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createAccess(AccessCreateDto accessCreateDto){
        return Response.created(URI.create("/access")).entity(accessService.create(accessCreateDto)).build();
    }

    @GET
    @Path("/{accessId}")
    @Produces("application/json")
    public Response getAccess(@PathParam("accessId") Long id){
        return Response.ok(accessService.get(id)).build();
    }

    @PUT
    @Path("/{accessId}")
    @Produces("application/json")
    public Response updateAccess(@PathParam("accessId") Long id){
        return Response.ok(accessService.update(id)).build();
    }

}
