package com.example.shipmanagement.repository;

import com.example.shipmanagement.model.Ship;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@ApplicationScoped
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
