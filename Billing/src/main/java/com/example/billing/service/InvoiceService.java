package com.example.billing.service;


import com.example.billing.bill.Bill;
import com.example.billing.converter.InvoiceConverter;
import com.example.billing.dto.InvoiceCreateDto;
import com.example.billing.dto.InvoiceDto;
import com.example.billing.dto.PersonDto;
import com.example.billing.model.Invoice;
import com.example.billing.repository.InvoiceRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class InvoiceService {

    @EJB
    private InvoiceRepository invoiceRepository;
    @EJB
    private InvoiceConverter invoiceConverter;

    public InvoiceService(InvoiceRepository invoiceRepository, InvoiceConverter invoiceConverter) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceConverter = invoiceConverter;
    }

    public InvoiceService() {
    }

    public PersonDto getPerson(int cc){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/PersonManagement-1.0-SNAPSHOT/api/person/" + cc);
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        if(response.getStatus() != 200){
            throw new WebApplicationException("Person not found", Response.Status.BAD_REQUEST);
        }
        return response.readEntity(PersonDto.class);
    }

    public InvoiceDto createInvoice(InvoiceCreateDto invoiceCreateDto) {
        // falta buscar a pessoa e adicionar a informacao a invoice e depois a txt ser a invoice ...
        PersonDto person = getPerson(invoiceCreateDto.getPersonCC());
        if(invoiceCreateDto.getDate().isEmpty() || invoiceCreateDto.getPrice() == 0.0){
            throw new WebApplicationException("Date is empty", Response.Status.BAD_REQUEST);
        }
        Invoice newInvoice = invoiceConverter.fromCreateDto(invoiceCreateDto, person);
        invoiceRepository.save(newInvoice);
        createBill(newInvoice, invoiceCreateDto.getPrice());
        return invoiceConverter.toDto(newInvoice);
    }

    private void createBill(Invoice invoice, double price) {
        try {
            Bill bill = new Bill(invoice.getPersonName(), invoice.getPersonNif(), invoice.getDate(),price , invoice.getPrice());

        File file = new File("/Users/goncalocravo/Desktop/fatura.txt");
        if(file.createNewFile()){
            FileWriter fileWriter = new FileWriter("/Users/goncalocravo/Desktop/fatura.txt");
            fileWriter.write(bill.getMessage());
            fileWriter.close();
        }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public List<InvoiceDto> getInvoices(int nif) {
        List<Invoice> invoiceList = invoiceRepository.getByNif(nif);
        return invoiceList.stream().map(invoice -> invoiceConverter.toDto(invoice)).collect(Collectors.toList());
    }
}
