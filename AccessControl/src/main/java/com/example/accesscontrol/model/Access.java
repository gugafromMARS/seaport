package com.example.accesscontrol.model;


import com.example.accesscontrol.dto.PersonDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "access")

public class Access {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
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

    public static AccessBuilder builder(){
        return new AccessBuilder();
    }

    public static class AccessBuilder {
        private Access access;

        public AccessBuilder() {
            this.access = new Access();
        }

        public AccessBuilder withEntryDate(LocalDateTime date){
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-mm-yyyy HH:mm");
            access.setEntryDate(date.format(dt));
            return this;
        }

        public AccessBuilder withOutDate(){
            access.setOutDate(null);
            return this;
        }

        public AccessBuilder withPersonDto(PersonDto personDto){
                access.setPersonDto(personDto);
                return this;
        }

        public AccessBuilder withDescription(String description){
            access.setDescription(description);
            return this;
        }

        public Access build(){
            return access;
        }
    }
}
