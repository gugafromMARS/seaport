package com.example.personmanagement.unit;

import com.example.personmanagement.converter.PersonConverterImp;
import com.example.personmanagement.dto.PersonCreateDto;
import com.example.personmanagement.dto.PersonDto;
import com.example.personmanagement.exceptions.CustomWebApplicationException;
import com.example.personmanagement.model.Person;
import com.example.personmanagement.repository.PersonRepository;
import com.example.personmanagement.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UnitTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonConverterImp personConverterImp;

    @InjectMocks
    private PersonService personService;

    private PersonCreateDto personCreateDto;
    private Person person;
    private PersonDto personDto;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        // Inicializa objetos de teste
        personCreateDto = new PersonCreateDto();
        personCreateDto.setCc(12345);
        personCreateDto.setNif(271570512);

        person = new Person();
        person.setName("Jose");
        person.setCc(12345);

        personDto = new PersonDto();
        personDto.setName("Jose");
        personDto.setCc(12345);
    }

    @Test
    @DisplayName("Should throw an exception if NIF is invalid")
    public void shouldThrowExceptionIfNifIsInvalid() {
        // Não precisa de mocks para métodos internos como checkNIF(), teste a lógica diretamente
        personCreateDto.setNif(11111);

        CustomWebApplicationException exception = assertThrows( CustomWebApplicationException.class, () -> {
            personService.createPerson(personCreateDto); // Método que chama checkNIF()
        });

        String expectedMessage = "Nif is not valid";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    @DisplayName("Should create person when NIF is valid")
    public void shouldCreatePersonWhenNifIsValid() {
        // Simula a validação do NIF sendo verdadeira
        personCreateDto.setNif(271570512); // Aqui, o NIF é considerado válido

        when(personRepository.getByCC(personCreateDto.getCc())).thenReturn(null);
        when(personConverterImp.fromCreateDto(personCreateDto)).thenReturn(person);
        when(personConverterImp.toDto(person)).thenReturn(personDto);

        PersonDto createdPerson = personService.createPerson(personCreateDto);

        assertNotNull(createdPerson);
        assertEquals("Jose", createdPerson.getName());
    }
}
