package com.example.billing.dto;

public class InvoiceCreateDto {
    private String personName;
    private int personNif;
    private String date;
    private double price;

    public String getPersonName() {
        return personName;
    }

    public int getPersonNif() {
        return personNif;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }
}
