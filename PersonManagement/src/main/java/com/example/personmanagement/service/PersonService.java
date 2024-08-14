package com.example.personmanagement.service;

import com.example.personmanagement.converter.PersonConverter;
import com.example.personmanagement.dto.PersonCreateDto;
import com.example.personmanagement.dto.PersonDto;
import com.example.personmanagement.model.Person;
import com.example.personmanagement.repository.PersonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class PersonService {

    @Inject
    private PersonConverter personConverter;
    @Inject
    private PersonRepository personRepository;

    public PersonDto createPerson(PersonCreateDto personCreateDto) {
        Person existingPerson = personRepository.getByCC(personCreateDto.getCc());
        if(existingPerson != null){
            throw new WebApplicationException("Person already exist", Response.Status.BAD_REQUEST);
        }
        existingPerson = personConverter.fromCreateDto(personCreateDto);
        personRepository.save(existingPerson);
        return personConverter.toDto(existingPerson);
    }

    public PersonDto getPerson(int ccNumber) {
        Person existingPerson = personRepository.getByCC(ccNumber);
        if(existingPerson == null){
            throw new WebApplicationException("User not found", Response.Status.NOT_FOUND);
        }
        return personConverter.toDto(existingPerson);
    }
}