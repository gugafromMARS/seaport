package com.example.personmanagement.service;

import com.example.personmanagement.converter.PersonConverter;
import com.example.personmanagement.dto.PersonCreateDto;
import com.example.personmanagement.dto.PersonDto;
import com.example.personmanagement.exceptions.CustomWebApplicationException;
import com.example.personmanagement.model.Person;
import com.example.personmanagement.repository.PersonRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Stateless
public class PersonService {

    @EJB
    private PersonConverter personConverter;
    @EJB
    private PersonRepository personRepository;

    public PersonService(PersonConverter personConverter, PersonRepository personRepository) {
        this.personConverter = personConverter;
        this.personRepository = personRepository;
    }

    public PersonService() {
    }

    public PersonDto createPerson(PersonCreateDto personCreateDto) {
        Person existingPerson = personRepository.getByCC(personCreateDto.getCc());
        if(existingPerson != null){
            throw new WebApplicationException("Person already exist", Response.Status.BAD_REQUEST);
        }
        checkNIF(personCreateDto.getNif());
        existingPerson = personConverter.fromCreateDto(personCreateDto);
        personRepository.save(existingPerson);
        return personConverter.toDto(existingPerson);

    }

    public void checkNIF(int nif){
        String[] nifReformatted = String.valueOf(nif).split("");
        if(nifReformatted.length != 9){
            throw new CustomWebApplicationException("Nif is not valid", 400);
        }
        int total = 0;
        int nifSize = nifReformatted.length;
        for(int i = 0; i < 8; i++){
            total += Integer.valueOf(nifReformatted[i]) * nifSize;
            nifSize--;
        }
        int rest = total % 11;
        int controlDigit;
        if(rest == 0 || rest == 1){
            controlDigit = 0;
        }else {
            controlDigit = 11 - rest;
        }
        if(Integer.valueOf(nifReformatted[8]) != controlDigit){
            throw new CustomWebApplicationException("Nif is not valid", 400);
        }
    }

    public PersonDto getPerson(int ccNumber) {
        Person existingPerson = personRepository.getByCC(ccNumber);
        if(existingPerson == null){
            throw new WebApplicationException("User not found", Response.Status.NOT_FOUND);
        }
        return personConverter.toDto(existingPerson);
    }
}