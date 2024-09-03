package com.example.cargomanagement.repository;

import com.example.cargomanagement.model.Cargo;
import com.example.cargomanagement.model.CargoType;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CargoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Cargo cargo){
        entityManager.persist(cargo);
    }

    public List<Cargo> getCargoByCargoType(String cargoType){
        for(CargoType ct : CargoType.values()){
            if(ct.name().equals(cargoType)){
                return entityManager.createQuery("FROM Cargo c WHERE c.cargoType = :cargoType", Cargo.class)
                        .setParameter("cargoType", cargoType)
                        .getResultList();
            }
        }
        return entityManager.createQuery("FROM Cargo c WHERE c.cargoType = :cargoType", Cargo.class)
                .setParameter("cargoType", CargoType.CONTAINER)
                .getResultList();
    }

    public List<Cargo> getCargoByShip(int mmsi){
        return entityManager.createQuery("FROM Cargo c JOIN c.shipDto s WHERE s.mmsi= :mmsi", Cargo.class)
                .setParameter("mmsi", mmsi)
                .getResultList();
    }
    public Cargo getCargoById(Long id){
        Cargo existingCargo = entityManager.createQuery("FROM Cargo c WHERE c.id = :id",Cargo.class)
                .setParameter("id", id)
                .getSingleResult();
        if(existingCargo == null){
            throw new WebApplicationException("Cargo not found", Response.Status.NOT_FOUND);
        }
        return existingCargo;
    }

    public Cargo getCargoByUUID(UUID uuid){
        Cargo existingCargo = entityManager.createQuery("FROM Cargo c WHERE c.cargoNumber = :uuid", Cargo.class)
                .setParameter("uuid", uuid)
                .getSingleResult();
        if(existingCargo == null){
            throw new WebApplicationException("Cargo not found", Response.Status.NOT_FOUND);
        }
        return existingCargo;
    }
}
