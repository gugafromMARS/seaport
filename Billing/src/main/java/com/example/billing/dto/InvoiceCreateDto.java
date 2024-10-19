package com.example.billing.dto;

public class InvoiceCreateDto {
    private int personCC;
    private String date;
    private double price;

    public int getPersonCC() {
        return personCC;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }
}
