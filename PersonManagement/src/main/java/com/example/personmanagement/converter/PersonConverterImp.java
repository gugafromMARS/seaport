package com.example.personmanagement.converter;

import com.example.personmanagement.dto.PersonCreateDto;
import com.example.personmanagement.dto.PersonDto;
import com.example.personmanagement.model.Person;

import javax.ejb.Stateless;


@Stateless
public class PersonConverterImp implements PersonConverter {

    public Person fromCreateDto(PersonCreateDto personCreateDto){
        return Person.builder()
                .withName(personCreateDto.getName())
                .withAge(personCreateDto.getAge())
                .withCC(personCreateDto.getCc())
                .withEmail(personCreateDto.getEmail())
                .withNif(personCreateDto.getNif())
                .withRole(personCreateDto.getRole())
                .build();
    }

    public PersonDto toDto(Person person){
        return PersonDto.builder()
                .withName(person.getName())
                .withCC(person.getCc())
                .withNif(person.getNif())
                .withEmail(person.getEmail())
                .withRole(person.getRole())
                .build();
    }
}
