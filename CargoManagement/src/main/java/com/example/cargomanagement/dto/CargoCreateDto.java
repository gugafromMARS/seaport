package com.example.cargomanagement.dto;
public class CargoCreateDto {
    private double weight;
    private double volume;
    private String cargoType;
    private String origin;
    private String estimatedArrivalDate;
    private String estimatedDepartureDate;
    private Long shipId;

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }

    public String getCargoType() {
        return cargoType;
    }

    public String getOrigin() {
        return origin;
    }

    public String getEstimatedArrivalDate() {
        return estimatedArrivalDate;
    }

    public String getEstimatedDepartureDate() {
        return estimatedDepartureDate;
    }

    public Long getShipId() {
        return shipId;
    }
}
