package com.example.accesscontrol.dto;

public class AccessOutDto {

    private Long id;
    private String entryDate;
    private String outDate;
    private PersonDto personDto;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }

    public static  AccessOutDtoBuilder builder(){
        return new AccessOutDtoBuilder();
    }

    public static class AccessOutDtoBuilder{
        private AccessOutDto accessOutDto;

        public AccessOutDtoBuilder() {
            this.accessOutDto = new AccessOutDto();
        }
        public AccessOutDtoBuilder withId(Long id){
            accessOutDto.setId(id);return this;
        }
        public AccessOutDtoBuilder withEntryDate(String date){
            accessOutDto.setEntryDate(date);return this;
        }
        public AccessOutDtoBuilder withOutDate(String date){
            accessOutDto.setOutDate(date);return this;
        }
        public AccessOutDtoBuilder withPerson(PersonDto person){
            accessOutDto.setPersonDto(person);return this;
        }
        public AccessOutDto build(){
            return accessOutDto;
        }

    }
}
