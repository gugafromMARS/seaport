package com.example.personmanagement.controller;

import com.example.personmanagement.dto.PersonCreateDto;
import com.example.personmanagement.service.PersonService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/person")
public class PersonController {

    @EJB
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public PersonController() {
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createPerson(PersonCreateDto personCreateDto){
        return Response.created(URI.create("/person")).entity(personService.createPerson(personCreateDto)).build();
    }

    @GET
    @Path("/{cc}")
    @Produces("application/json")
    public Response get(@PathParam("cc") int ccNumber){
        return Response.ok(personService.getPerson(ccNumber)).build();
    }
}