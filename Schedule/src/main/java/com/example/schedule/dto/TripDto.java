package com.example.schedule.dto;



import java.time.LocalDate;
import java.util.List;

public class TripDto {

    private Long id;
    private String date;
    private ShipDto shipDto;
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

    public ShipDto getShipDto() {
        return shipDto;
    }

    public void setShipDto(ShipDto shipDto) {
        this.shipDto = shipDto;
    }

    public List<PersonDto> getPersonDtoList() {
        return personDtoList;
    }

    public void setPersonDtoList(List<PersonDto> personDtoList) {
        this.personDtoList = personDtoList;
    }

    public static TripDtoBuilder builder(){
        return new TripDtoBuilder();
    }


    public static class TripDtoBuilder{
        private TripDto tripDto;

        public TripDtoBuilder() {
            this.tripDto = new TripDto();
        }

        public TripDtoBuilder withId(Long id){
            tripDto.setId(id);
            return this;
        }

        public TripDtoBuilder withDate(LocalDate date){
            tripDto.setDate(date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth());
            return this;
        }
        public TripDtoBuilder withShipId(ShipDto shipDto){
            tripDto.setShipDto(shipDto);
            return this;
        }
        public TripDtoBuilder withPeople(List<PersonDto> people){
            tripDto.setPersonDtoList(people);
            return this;
        }
        public TripDto build(){
            return tripDto;
        }
    }
}
