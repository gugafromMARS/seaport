package com.example.billing.bill;

public class Bill {
    private String message;

    private static String personName;
    private int personNif;
    private String date;
    private double price;
    private double total;

    public Bill(String name, int nif, String date, double subtotal,double total) {
        personName = name;
        personNif = nif;
        this.date = date;
        price = subtotal;
        this.total = total;
        message = "***********SEAPORT INVOICE****************" + "\n" +
                "NAME: " + personName + "\n" +
                "NIF:" + personNif + "\n" +
                "DATE: " + date + "\n" +
                "SUBTOTAL: " + subtotal + "\n" +
                "TAX: 23%" + "\n" +
                "TOTAL: " + total;
    }

    public String getMessage() {
        return message;
    }
}
