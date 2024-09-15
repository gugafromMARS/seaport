package com.example.schedule.service;

import com.example.schedule.converter.TripConverter;
import com.example.schedule.converter.TripConverterImp;
import com.example.schedule.dto.*;
import com.example.schedule.model.Trip;
import com.example.schedule.repository.TripRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class TripService {

    @EJB
    private TripRepository tripRepository;
    @EJB
    private TripConverter tripConverter;

    public TripService(TripRepository tripRepository, TripConverter tripConverter) {
        this.tripRepository = tripRepository;
        this.tripConverter = tripConverter;
    }

    public TripService() {
    }

    public TripDto create(TripCreateDto tripCreateDto) {
        ShipDto shipDto = getShip(tripCreateDto);
        Trip existingTrip = tripRepository.getTripByShipNumberAndDate(tripCreateDto);
        if(existingTrip != null){
            throw new WebApplicationException("Trip already registered", Response.Status.BAD_REQUEST);
        }
        existingTrip = tripConverter.fromCreateDto(tripCreateDto, shipDto);
        tripRepository.save(existingTrip);
        return tripConverter.toDto(existingTrip);
    }

    private ShipDto getShip(TripCreateDto tripCreateDto){
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/ShipManagement-1.0-SNAPSHOT/api/ship/mmsi/" + tripCreateDto.getMmsi());
        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();
        if(response.getStatus() != 200){
            throw new WebApplicationException("Ship not found", Response.Status.BAD_REQUEST);
        }
        return response.readEntity(ShipDto.class);
    }

    private PersonDto getPerson(int cc){
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/PersonManagement-1.0-SNAPSHOT/api/person/" + cc);
        Response response = webTarget.request(MediaType.APPLICATION_JSON).get();
        if(response.getStatus() != 200){
            throw new WebApplicationException("Person not found", Response.Status.BAD_REQUEST);
        }
        return response.readEntity(PersonDto.class);
    }

    public List<TripPersonDto> getTripByPerson(int cc) {
        return tripConverter.fromCcOfPerson(tripRepository.getTripFromCC(cc));
    }

    public TripDto updateTrip(TripAddPersonDto tripAddPersonDto) {
        PersonDto personDto = getPerson(tripAddPersonDto.getCc());
        Trip existingTrip = tripRepository.getById(tripAddPersonDto.getTripId());
        if(existingTrip != null){
           List<PersonDto> persons= existingTrip.getPersonList()
                   .stream()
                   .filter(p -> p.getCc() == tripAddPersonDto.getCc())
                   .collect(Collectors.toList());
           if(persons.size() > 0){
               throw new WebApplicationException("Person already registered in this trip", Response.Status.BAD_REQUEST);
           }
        }
        existingTrip.getPersonList().add(personDto);
        tripRepository.merge(existingTrip);
        return tripConverter.toDto(existingTrip);
    }

    public List<TripShipDto> getTripsByShip(int mmsi) {
        return tripConverter.fromListOfTrips(tripRepository.getTripFromMMSI(mmsi));
    }

    public TripDto getTrip(Long tripId) {
        return tripConverter.toDto(tripRepository.getById(tripId));
    }

    public void deleteById(Long tripId) {
        tripRepository.delete(tripId);
    }
}
