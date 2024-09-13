package com.example.shipmanagement.repository;

import com.example.shipmanagement.model.Ship;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;


@Stateless
public class ShipRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Ship ship){
        entityManager.persist(ship);
    }

    public Ship findByMMSI(int mmsi){
        List<Ship> ships = entityManager.createQuery("FROM Ship s Where s.mmsi = :mmsi", Ship.class)
                .setParameter("mmsi", mmsi)
                .getResultList();
        if(ships.isEmpty()){
            return null;
        }
        return ships.get(0);
    }


}
