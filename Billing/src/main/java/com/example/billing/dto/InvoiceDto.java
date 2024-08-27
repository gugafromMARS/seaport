package com.example.billing.dto;

import com.example.billing.model.Invoice;

public class InvoiceDto {

    private Long id;

    private String personName;
    private int personNif;
    private String date;
    private double price;
    private int vat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonNif() {
        return personNif;
    }

    public void setPersonNif(int personNif) {
        this.personNif = personNif;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public static InvoiceDtoBuilder builder(){
        return new InvoiceDtoBuilder();
    }

    public static class InvoiceDtoBuilder{
        private InvoiceDto invoiceDto;

        public InvoiceDtoBuilder() {
            this.invoiceDto = new InvoiceDto();
        }


        public InvoiceDtoBuilder withId(Long id){
            invoiceDto.setId(id);
            return this;
        }

        public InvoiceDtoBuilder withPersonNif(int nif){
            invoiceDto.setPersonNif(nif);
            return this;
        }

        public InvoiceDtoBuilder withVat(int vat){
            invoiceDto.setVat(vat);
            return this;
        }
        public InvoiceDtoBuilder withPrice(double price){
            invoiceDto.setPrice(price);
            return this;
        }
        public InvoiceDtoBuilder withPersonName(String name){
            invoiceDto.setPersonName(name);
            return this;
        }

        public InvoiceDtoBuilder withDate(String date){
            invoiceDto.setDate(date);
            return this;
        }
        public InvoiceDto build(){
            return invoiceDto;
        }
    }
}
