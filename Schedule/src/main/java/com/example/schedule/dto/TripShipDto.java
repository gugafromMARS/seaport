package com.example.schedule.dto;

import java.time.LocalDate;
import java.util.List;

public class TripShipDto {

    private Long id;
    private String date;
    private List<PersonDto> personDtoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<PersonDto> getPersonDtoList() {
        return personDtoList;
    }

    public void setPersonDtoList(List<PersonDto> personDtoList) {
        this.personDtoList = personDtoList;
    }

    public static TripShipDtoBuilder builder(){
        return new TripShipDtoBuilder();
    }

    public static class TripShipDtoBuilder{
        private TripShipDto tripShipDto;

        public TripShipDtoBuilder() {
            this.tripShipDto = new TripShipDto();
        }

        public TripShipDtoBuilder withId(Long id){
            tripShipDto.setId(id);return this;
        }
        public TripShipDtoBuilder withDate(LocalDate date){
            tripShipDto.setDate(date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth());return this;
        }
        public TripShipDtoBuilder withPeople(List<PersonDto> people){
            tripShipDto.setPersonDtoList(people);return this;
        }
        public TripShipDto build(){
            return tripShipDto;
        }
    }
}
