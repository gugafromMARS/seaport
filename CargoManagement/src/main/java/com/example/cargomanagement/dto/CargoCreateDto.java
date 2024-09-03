package com.example.cargomanagement.dto;

import java.util.UUID;

public class CargoCreateDto {
    private double weight;
    private double volume;
    private String cargoType;
    private String origin;

    private final UUID uuid = UUID.randomUUID();
    private String estimatedArrivalDate;
    private String estimatedDepartureDate;
    private int mmsi;

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

    public UUID getUuid() {
        return uuid;
    }

    public int getMmsi() {
        return mmsi;
    }
}
