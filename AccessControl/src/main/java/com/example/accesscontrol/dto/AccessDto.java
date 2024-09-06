package com.example.accesscontrol.dto;


public class AccessDto {
    private Long id;
    private String entryDate;
    private String outDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static AccessDtoBuilder builder(){
        return new AccessDtoBuilder();
    }

    public static class AccessDtoBuilder{
        private AccessDto accessDto;

        public AccessDtoBuilder() {
            this.accessDto = new AccessDto();
        }

        public AccessDtoBuilder withId(Long id){
            accessDto.setId(id);return this;
        }
        public AccessDtoBuilder withEntryDate(String date){
            accessDto.setEntryDate(date);return this;
        }
        public AccessDtoBuilder withOutDate(String date){
            accessDto.setOutDate(date);return this;
        }
        public AccessDtoBuilder withPerson(PersonDto person){
            accessDto.setPersonDto(person);return this;
        }
        public AccessDtoBuilder withDescription(String description){
            accessDto.setDescription(description);return this;
        }

        public AccessDto build(){
            return accessDto;
        }


    }
}
