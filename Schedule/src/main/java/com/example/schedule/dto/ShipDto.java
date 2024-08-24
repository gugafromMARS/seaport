package com.example.schedule.dto;

import com.example.schedule.model.ShipType;

import javax.persistence.Embeddable;


@Embeddable
public class ShipDto {

    private String name;
    private String radioNumber;
    private int mmsi;
    private ShipType shipType;
    private String flag;
    private String ownerEmail;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRadioNumber() {
        return radioNumber;
    }

    public void setRadioNumber(String radioNumber) {
        this.radioNumber = radioNumber;
    }

    public int getMmsi() {
        return mmsi;
    }

    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    @Override
    public String toString() {
        return "ShipDto{" +
                "name='" + name + '\'' +
                ", radioNumber='" + radioNumber + '\'' +
                ", mmsi=" + mmsi +
                ", shipType=" + shipType +
                ", flag='" + flag + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                '}';
    }
}
