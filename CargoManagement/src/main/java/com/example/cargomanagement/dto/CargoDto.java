package com.example.cargomanagement.dto;

import com.example.cargomanagement.model.CargoType;

import java.time.LocalDate;


public class CargoDto {

    private Long id;
    private double weight;
    private double volume;
    private CargoType cargoType;
    private String origin;
    private String estimatedArrivalDate;
    private String estimatedDepartureDate;
    private ShipDto shipDto;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getEstimatedArrivalDate() {
        return estimatedArrivalDate;
    }

    public void setEstimatedArrivalDate(String estimatedArrivalDate) {
        this.estimatedArrivalDate = estimatedArrivalDate;
    }

    public String getEstimatedDepartureDate() {
        return estimatedDepartureDate;
    }

    public void setEstimatedDepartureDate(String estimatedDepartureDate) {
        this.estimatedDepartureDate = estimatedDepartureDate;
    }

    public ShipDto getShipDto() {
        return shipDto;
    }

    public void setShipDto(ShipDto shipDto) {
        this.shipDto = shipDto;
    }

    public static CargoDtoBuilder builder(){
        return new CargoDtoBuilder();
    }

    public static class CargoDtoBuilder{
        private CargoDto cargoDto;

        public CargoDtoBuilder() {
            this.cargoDto = new CargoDto();
        }

        public CargoDtoBuilder withId(Long id){
            cargoDto.setId(id);
            return this;
        }

        public CargoDtoBuilder withWeight(double weight){
            cargoDto.setWeight(weight);
            return this;
        }
        public CargoDtoBuilder withVolume(double volume){
            cargoDto.setVolume(volume);
            return this;
        }
        public CargoDtoBuilder withCargoType(CargoType cargoType){
            cargoDto.setCargoType(cargoType);
            return this;
        }

        public CargoDtoBuilder withOrigin(String origin){
            cargoDto.setOrigin(origin);
            return this;
        }
        public CargoDtoBuilder withArrivalDate(LocalDate date){
            cargoDto.setEstimatedArrivalDate(date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth());
            return this;
        }
        public CargoDtoBuilder withDepartureDate(LocalDate date){
            cargoDto.setEstimatedDepartureDate(date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth());
            return this;
        }

        public CargoDtoBuilder withShip(ShipDto ship){
            cargoDto.setShipDto(ship);
            return this;
        }
        public CargoDto build(){
            return cargoDto;
        }
    }
}
