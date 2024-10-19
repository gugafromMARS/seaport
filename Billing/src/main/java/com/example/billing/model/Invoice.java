package com.example.billing.model;


import javax.persistence.*;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
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

    public static InvoiceBuilder builder(){
        return new InvoiceBuilder();
    }

    public static class InvoiceBuilder {
        private Invoice invoice;

        public InvoiceBuilder() {
            this.invoice = new Invoice();
        }

        public InvoiceBuilder withPersonName(String name){
            invoice.setPersonName(name);
            return this;
        }
        public InvoiceBuilder withNif(int nif){
            invoice.setPersonNif(nif);
            return this;
        }


        public InvoiceBuilder withDate(String date){
            invoice.setDate(date);
            return this;
        }

        public InvoiceBuilder withPrice(double amount){
            invoice.setPrice(amount*1.23);
            return this;
        }
        public InvoiceBuilder withVat(){
            invoice.setVat(23);
            return this;
        }

        public Invoice build(){
            return invoice;
        }
    }
}
