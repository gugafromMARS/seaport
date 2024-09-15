package com.example.personmanagement.integration;

import com.example.personmanagement.converter.PersonConverterImp;
import com.example.personmanagement.dto.PersonCreateDto;
import com.example.personmanagement.dto.PersonDto;
import com.example.personmanagement.model.Person;
import com.example.personmanagement.repository.PersonRepository;
import com.example.personmanagement.service.PersonService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;
    @Mock
    private PersonConverterImp personConverterImp;
    @InjectMocks
    private PersonService personService;
    private Person person;
    private PersonCreateDto personCreateDto;
    private PersonDto personDto;


    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        personCreateDto = new PersonCreateDto();
        personCreateDto.setName("jose");
        personCreateDto.setNif(271570512);
        personCreateDto.setCc(12345);

        person = new Person();
        person.setName("jose");
        person.setNif(271570512);
        person.setCc(12345);

        personDto = new PersonDto();
        personDto.setName("jose");
        personDto.setNif(271570512);
        personDto.setCc(12345);
    }

    @Nested
    public class testing {

        @Test
        @DisplayName("Create a person, save it and return person dto")
        public void create() throws Exception {
            when(personRepository.getByCC(12345)).thenReturn(null);
            when(personConverterImp.fromCreateDto(personCreateDto)).thenReturn(person);
            when(personConverterImp.toDto(person)).thenReturn(personDto);

            PersonDto result = personService.createPerson(personCreateDto);

            verify(personRepository).save(person);
            verify(personConverterImp).fromCreateDto(personCreateDto);
            verify(personConverterImp).toDto(person);

            assertNotNull(result);
            assertEquals("jose", result.getName());
            assertEquals(271570512, result.getNif());
        }

        @Test
        @DisplayName("Get person by cc and return persondto if exists")
        public void getExistPersonByCC() throws Exception {
            when(personRepository.getByCC(1234)).thenReturn(null);
            when(personConverterImp.fromCreateDto(personCreateDto)).thenReturn(person);
            when(personConverterImp.toDto(person)).thenReturn(personDto);

            PersonDto pDto = personService.createPerson(personCreateDto);

            verify(personRepository).save(person);
            assertNotNull(pDto);
            assertEquals("jose", pDto.getName());

            when(personRepository.getByCC(12345)).thenReturn(person);

            Person existingPerson = personRepository.getByCC(12345);

            assertNotNull(existingPerson);
            assertEquals("jose", existingPerson.getName());

            when(personConverterImp.toDto(existingPerson)).thenReturn(personDto);

            PersonDto existingPersonDto = personConverterImp.toDto(existingPerson);
            verify(personConverterImp, times(2)).toDto(existingPerson);
            assertNotNull(existingPersonDto);
            assertEquals("jose", existingPersonDto.getName());

        }
    }

}
