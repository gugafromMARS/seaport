package com.example.billing.controller;


import com.example.billing.dto.InvoiceCreateDto;
import com.example.billing.service.InvoiceService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/invoice")
public class InvoiceController {

    @EJB
    private InvoiceService invoiceService;

    public InvoiceController() {
    }

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(InvoiceCreateDto invoiceCreateDto){
        return Response.created(URI.create("/invoice"))
                .entity(invoiceService.createInvoice(invoiceCreateDto))
                .build();
    }

    @GET
    public Response getByNif(int nif){
        return Response.ok(invoiceService.getInvoices(nif)).build();
    }
}
