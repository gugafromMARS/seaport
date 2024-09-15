package com.example.accesscontrol.converter;

import com.example.accesscontrol.dto.AccessCreateDto;
import com.example.accesscontrol.dto.AccessEntryDto;
import com.example.accesscontrol.dto.AccessOutDto;
import com.example.accesscontrol.dto.PersonDto;
import com.example.accesscontrol.model.Access;

public interface AccessConverter {

    Access fromCreateDto(AccessCreateDto accessCreateDto, PersonDto personDto);
    AccessOutDto toOutDto(Access access);
    AccessEntryDto toEntryDto(Access access);
}
