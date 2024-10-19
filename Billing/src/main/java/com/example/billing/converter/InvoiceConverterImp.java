package com.example.billing.converter;


import com.example.billing.dto.InvoiceCreateDto;
import com.example.billing.dto.InvoiceDto;
import com.example.billing.dto.PersonDto;
import com.example.billing.model.Invoice;

import javax.ejb.Stateless;

@Stateless
public class InvoiceConverterImp implements InvoiceConverter{


    public Invoice fromCreateDto(InvoiceCreateDto invoiceCreateDto, PersonDto personDto){
        return Invoice.builder()
                .withPersonName(personDto.getName())
                .withNif(personDto.getNif())
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
