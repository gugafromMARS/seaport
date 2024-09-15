package com.example.personmanagement.converter;

import com.example.personmanagement.dto.PersonCreateDto;
import com.example.personmanagement.dto.PersonDto;
import com.example.personmanagement.model.Person;

public interface PersonConverter {


    Person fromCreateDto(PersonCreateDto personCreateDto);
    PersonDto toDto(Person person);
}
