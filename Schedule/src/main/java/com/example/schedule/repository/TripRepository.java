package com.example.schedule.repository;


import com.example.schedule.dto.TripAddPersonDto;
import com.example.schedule.dto.TripCreateDto;
import com.example.schedule.model.Trip;
import org.hibernate.Hibernate;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class TripRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Trip trip) {
        entityManager.persist(trip);
    }

    @Transactional
    public void merge(Trip trip){
        entityManager.merge(trip);
    }

    @Transactional
    public void delete(Long tripId){
        Trip existingTrip = getById(tripId);
        entityManager.remove(existingTrip);
    }

    @Transactional
    public Trip getById(Long tripId) {
        try {
            Trip trip = entityManager.createQuery("FROM Trip t WHERE t.id = :tripId", Trip.class)
                    .setParameter("tripId", tripId)
                    .getSingleResult();
            Hibernate.initialize(trip.getPersonList());
            return trip;
        } catch (NoResultException e){
            throw new WebApplicationException("Trip not found", Response.Status.NOT_FOUND);
        }
    }

    public List<Trip> getTripFromMMSI(int mmsi){
        return entityManager.createQuery("FROM Trip t WHERE t.shipDto.mmsi = :mmsi", Trip.class)
                .setParameter("mmsi", mmsi)
                .getResultList();
    }

    public Trip getTripByShipNumberAndDate(TripCreateDto tripCreateDto) {
        if (tripCreateDto.getDate().contains("-")) {
            String[] date = tripCreateDto.getDate().split("-");
            if (date.length != 3) {
                return null;
            } else {
                try {
                    LocalDate dt = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
                    Trip trip = entityManager.createQuery("FROM Trip t WHERE t.shipDto.mmsi = :mmsi AND t.date = :date", Trip.class)
                            .setParameter("mmsi", tripCreateDto.getMmsi())
                            .setParameter("date", dt)
                            .getSingleResult();
                    return trip;
                } catch (NoResultException e) {
                    return null;
                }
            }
        }
        return null;
    }




}



