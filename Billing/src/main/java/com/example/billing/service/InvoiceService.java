package com.example.billing.service;


import com.example.billing.converter.InvoiceConverter;
import com.example.billing.dto.InvoiceCreateDto;
import com.example.billing.dto.InvoiceDto;
import com.example.billing.model.Invoice;
import com.example.billing.repository.InvoiceRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class InvoiceService {

    @EJB
    private final InvoiceRepository invoiceRepository;
    @EJB
    private final InvoiceConverter invoiceConverter;

    public InvoiceService(InvoiceRepository invoiceRepository, InvoiceConverter invoiceConverter) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceConverter = invoiceConverter;
    }

    public InvoiceDto createInvoice(InvoiceCreateDto invoiceCreateDto) {
        if(invoiceCreateDto.getDate().isEmpty() || invoiceCreateDto.getPrice() == 0.0){
            throw new WebApplicationException("Date is empty", Response.Status.BAD_REQUEST);
        }
        Invoice newInvoice = invoiceConverter.fromCreateDto(invoiceCreateDto);
        invoiceRepository.save(newInvoice);
        return invoiceConverter.toDto(newInvoice);
    }

    public List<InvoiceDto> getInvoices(int nif) {
        List<Invoice> invoiceList = invoiceRepository.getByNif(nif);
        return invoiceList.stream().map(invoice -> invoiceConverter.toDto(invoice)).collect(Collectors.toList());
    }
}
