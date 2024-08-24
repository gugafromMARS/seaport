package com.example.schedule.dto;




import java.time.LocalDate;


public class TripPersonDto {

    private Long id;
    private String date;

    private ShipDto ship;

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

    public ShipDto getShip() {
        return ship;
    }

    public void setShip(ShipDto ship) {
        this.ship = ship;
    }



    public static TripPersonDtoBuilder builder(){
        return new TripPersonDtoBuilder();
    }

    public static class TripPersonDtoBuilder {
        private TripPersonDto tripPersonDto;

        public TripPersonDtoBuilder() {
            this.tripPersonDto = new TripPersonDto();
        }

        public TripPersonDtoBuilder withId(Long id){
            tripPersonDto.setId(id);
            return this;
        }
        public TripPersonDtoBuilder withDate(LocalDate date){
            tripPersonDto.setDate(date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth());
            return this;
        }
        public TripPersonDtoBuilder withShipId(ShipDto shipDto){
            tripPersonDto.setShip(shipDto);
            return this;
        }

        public TripPersonDto build(){
            return tripPersonDto;
        }
    }

}
