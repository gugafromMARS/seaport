package com.example.shipmanagement.dto;


import com.example.shipmanagement.model.ShipType;


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


    public static ShipDtoBuilder builder(){
        return new ShipDtoBuilder();
    }

    public static class ShipDtoBuilder {
        private ShipDto shipDto;

        public ShipDtoBuilder() {
            this.shipDto = new ShipDto();
        }

        public ShipDtoBuilder withName(String name){
            shipDto.setName(name);
            return this;
        }

        public ShipDtoBuilder withRadioNumber(String radioNumber){
            shipDto.setRadioNumber(radioNumber);
            return this;
        }

        public ShipDtoBuilder withMMSI (int mmsiNumber){
            shipDto.setMmsi(mmsiNumber);
            return this;
        }

        public ShipDtoBuilder withShipType(ShipType shipType){
            shipDto.setShipType(shipType);
            return this;
        }

        public ShipDtoBuilder withFlag(String countryFlag){
            shipDto.setFlag(countryFlag);
            return this;
        }
        public ShipDtoBuilder withOwnerEmail(String ownerEmail){
            shipDto.setOwnerEmail(ownerEmail);
            return this;
        }

        public ShipDto build(){
            return shipDto;
        }
    }
}
