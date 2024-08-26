package com.example.personmanagement.service;

import com.example.personmanagement.converter.PersonConverter;
import com.example.personmanagement.dto.PersonCreateDto;
import com.example.personmanagement.dto.PersonDto;
import com.example.personmanagement.model.Person;
import com.example.personmanagement.repository.PersonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
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
        if(checkNIF(personCreateDto.getNif())){
            existingPerson = personConverter.fromCreateDto(personCreateDto);
            personRepository.save(existingPerson);
            return personConverter.toDto(existingPerson);
        } else{
            throw new WebApplicationException("Nif is not valid", Response.Status.BAD_REQUEST);
        }
    }

    private boolean checkNIF(int nif){
        String[] nifReformatted = String.valueOf(nif).split("");
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
        return Integer.valueOf(nifReformatted[8]) == controlDigit;
    }

    public PersonDto getPerson(int ccNumber) {
        Person existingPerson = personRepository.getByCC(ccNumber);
        if(existingPerson == null){
            throw new WebApplicationException("User not found", Response.Status.NOT_FOUND);
        }
        return personConverter.toDto(existingPerson);
    }
}