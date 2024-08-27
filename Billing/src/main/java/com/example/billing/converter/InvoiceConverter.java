package com.example.billing.converter;


import com.example.billing.dto.InvoiceCreateDto;
import com.example.billing.dto.InvoiceDto;
import com.example.billing.model.Invoice;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InvoiceConverter {


    public Invoice fromCreateDto(InvoiceCreateDto invoiceCreateDto){
        return Invoice.builder()
                .withPersonName(invoiceCreateDto.getPersonName())
                .withNif(invoiceCreateDto.getPersonNif())
                .withDate(invoiceCreateDto.getDate())
                .withPrice(invoiceCreateDto.getPrice())
                .withVat()
                .build();
    }

    public InvoiceDto toDto(Invoice invoice){
        return InvoiceDto.builder()
                .withId(invoice.getId())
                .withPersonName(invoice.getPersonName())
                .withPersonNif(invoice.getPersonNif())
                .withDate(invoice.getDate())
                .withPrice(invoice.getPrice())
                .withVat(invoice.getVat())
                .build();
    }
}
