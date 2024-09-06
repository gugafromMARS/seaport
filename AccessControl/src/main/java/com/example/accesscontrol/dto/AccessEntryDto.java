package com.example.accesscontrol.dto;



public class AccessEntryDto {

    private Long id;
    private String entryDate;
    private PersonDto personDto;
    private String description;

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

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static AccessEntryDtoBuilder builder(){
        return new AccessEntryDtoBuilder();
    }

    public static class AccessEntryDtoBuilder {
        private AccessEntryDto accessEntryDto;

        public AccessEntryDtoBuilder() {
            this.accessEntryDto = new AccessEntryDto();
        }

        public AccessEntryDtoBuilder withId(Long id){
            accessEntryDto.setId(id);
            return this;
        }

        public AccessEntryDtoBuilder withEntryDate(String date){
            accessEntryDto.setEntryDate(date);
            return this;
        }

        public AccessEntryDtoBuilder withPerson(PersonDto person){
            accessEntryDto.setPersonDto(person);return this;
        }
        public AccessEntryDtoBuilder withDescription(String description){
            accessEntryDto.setDescription(description);return this;
        }

        public AccessEntryDto build(){
            return accessEntryDto;
        }
    }

}
