package com.example.cargomanagement.model;


import com.example.cargomanagement.dto.ShipDto;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private double weight;
    private double volume;
    private CargoType cargoType;
    private String origin;
    private LocalDate estimatedArrivalDate;
    private LocalDate estimatedDepartureDate;
    @Embedded
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

    public LocalDate getEstimatedArrivalDate() {
        return estimatedArrivalDate;
    }

    public void setEstimatedArrivalDate(LocalDate estimatedArrivalDate) {
        this.estimatedArrivalDate = estimatedArrivalDate;
    }

    public LocalDate getEstimatedDepartureDate() {
        return estimatedDepartureDate;
    }

    public void setEstimatedDepartureDate(LocalDate estimatedDepartureDate) {
        this.estimatedDepartureDate = estimatedDepartureDate;
    }

    public ShipDto getShipDto() {
        return shipDto;
    }

    public void setShipDto(ShipDto shipDto) {
        this.shipDto = shipDto;
    }

    public static CargoBuilder builder(){
        return new CargoBuilder();
    }

    public static class CargoBuilder {
        private Cargo cargo;

        public CargoBuilder() {
            this.cargo = new Cargo();
        }

        public CargoBuilder withWeight(double weight){
            cargo.setWeight(weight);
            return this;
        }

        public CargoBuilder withVolume(double volume){
            cargo.setVolume(volume);
            return this;
        }

        public CargoBuilder withCargoType(String type){
            if (type == null){
                cargo.setCargoType(CargoType.CONTAINER);
                return this;
            }
            for(CargoType s : CargoType.values()){
                if(s.name().equals(type.toUpperCase())){
                    cargo.setCargoType(s);
                    return this;
                }
            }
            cargo.setCargoType(CargoType.CONTAINER);
            return this;
        }

        public CargoBuilder withOrigin(String origin){
            cargo.setOrigin(origin);
            return this;
        }

        public CargoBuilder withDate(DateType dateType, String date){
            if(date == null || !date.contains("-")){
                cargo.setEstimatedArrivalDate(LocalDate.now());
                return this;
            }
            String[] dateSplit = date.split("-");
            if(dateSplit.length != 3){
                cargo.setEstimatedArrivalDate(LocalDate.now());
                return this;
            }
            if(dateType.name().equals("ARRIVAL")){
                cargo.setEstimatedArrivalDate(LocalDate.of(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2])));
                return this;
            }else {
                cargo.setEstimatedDepartureDate(LocalDate.of(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2])));
                return this;
            }
        }

        public CargoBuilder withShip(ShipDto ship){
            cargo.setShipDto(ship);
            return this;
        }

        public Cargo build(){
            return cargo;
        }
    }
}
