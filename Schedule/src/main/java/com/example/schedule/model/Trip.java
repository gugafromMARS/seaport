package com.example.schedule.model;



import com.example.schedule.dto.PersonDto;
import com.example.schedule.dto.ShipDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDate date;

    @Embedded
    private ShipDto shipDto;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<PersonDto> personList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ShipDto getShipDto() {
        return shipDto;
    }

    public void setShipDto(ShipDto shipDto) {
        this.shipDto = shipDto;
    }

    public List<PersonDto> getPersonList() {
        return personList;
    }

    public void setPersonList(List<PersonDto> personList) {
        this.personList = personList;
    }

    public static TripBuilder builder(){
        return new TripBuilder();
    }

    public  static  class TripBuilder{
        private Trip trip;

        public TripBuilder() {
            this.trip = new Trip();
        }

        public TripBuilder withDate(String date){
            if(date.contains("-")){
                String[] dateSplit = date.split("-");
                trip.setDate(LocalDate.of(
                        Integer.parseInt(dateSplit[0]),
                        Integer.parseInt(dateSplit[1]),
                        Integer.parseInt(dateSplit[2])));
                return this;
            }
            trip.setDate(LocalDate.now());return this;
        }

        public TripBuilder withShip(ShipDto shipDto){
            trip.setShipDto(shipDto);
            return this;
        }

        public TripBuilder withPersons(){
            trip.setPersonList(new ArrayList<>());return this;
        }

        public Trip build(){
            return trip;
        }
    }
}
