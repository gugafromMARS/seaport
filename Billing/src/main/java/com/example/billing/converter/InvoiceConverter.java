package com.example.billing.converter;

import com.example.billing.dto.InvoiceCreateDto;
import com.example.billing.dto.InvoiceDto;
import com.example.billing.dto.PersonDto;
import com.example.billing.model.Invoice;

public interface InvoiceConverter {

    Invoice fromCreateDto(InvoiceCreateDto invoiceCreateDto, PersonDto personDto);
    InvoiceDto toDto(Invoice invoice);
}
