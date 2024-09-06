package com.example.accesscontrol.dto;

import java.time.LocalDateTime;

public class AccessCreateDto {


    private LocalDateTime entryDate;
    private PersonDto personDto;
    private String description;


    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
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
}
