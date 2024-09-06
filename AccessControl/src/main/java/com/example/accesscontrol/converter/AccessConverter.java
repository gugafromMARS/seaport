package com.example.accesscontrol.converter;


import com.example.accesscontrol.dto.AccessCreateDto;
import com.example.accesscontrol.dto.AccessEntryDto;
import com.example.accesscontrol.dto.AccessOutDto;
import com.example.accesscontrol.dto.PersonDto;
import com.example.accesscontrol.model.Access;

import javax.ejb.Stateless;


@Stateless
public class AccessConverter {

    public Access fromCreateDto(AccessCreateDto accessCreateDto, PersonDto personDto){
        return Access.builder()
                .withEntryDate(accessCreateDto.getEntryDate())
                .withOutDate()
                .withPersonDto(personDto)
                .withDescription(accessCreateDto.getDescription())
                .build();
    }

    public AccessOutDto toOutDto(Access access){
        return AccessOutDto.builder()
                .withId(access.getId())
                .withEntryDate(access.getEntryDate())
                .withOutDate(access.getOutDate())
                .withPerson(access.getPersonDto())
                .build();
    }

    public AccessEntryDto toEntryDto(Access access){
        return AccessEntryDto.builder()
                .withId(access.getId())
                .withEntryDate(access.getEntryDate())
                .withPerson(access.getPersonDto())
                .withDescription(access.getDescription())
                .build();
    }
}
