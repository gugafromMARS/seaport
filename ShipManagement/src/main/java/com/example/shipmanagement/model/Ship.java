package com.example.shipmanagement.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="ship")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String radioNumber;
    private int mmsi;
    private ShipType shipType;
    private String flag;
    private String ownerEmail;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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


    public static ShipBuilder builder(){
        return new ShipBuilder();
    }

    public static class ShipBuilder {
        private Ship ship;

        public ShipBuilder() {
            this.ship = new Ship();
        }

        public ShipBuilder withName(String name){
            ship.setName(name);
            return this;
        }

        public ShipBuilder withRadioNumber(String radioNumber){
            ship.setRadioNumber(radioNumber);
            return this;
        }

        public ShipBuilder withMMSI (int mmsiNumber){
            ship.setMmsi(mmsiNumber);
            return this;
        }

        public ShipBuilder withShipType(String shipType){
            if(shipType.isEmpty()){
                ship.setShipType(ShipType.CRUISE);
                return this;
            }
            for (ShipType st: ShipType.values()){
                if(st.name().equals(shipType.toUpperCase())){
                    ship.setShipType(st);
                    return this;
                }
            }
            ship.setShipType(ShipType.CRUISE);
            return this;
        }

        public ShipBuilder withFlag(String countryFlag){
            ship.setFlag(countryFlag);
            return this;
        }
        public ShipBuilder withOwnerEmail(String ownerEmail){
            ship.setOwnerEmail(ownerEmail);
            return this;
        }

        public Ship build(){
            return ship;
        }

    }
}
