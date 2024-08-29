package com.example.cargomanagement.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class CargoRepository {

    @PersistenceContext
    private EntityManager entityManager;


}
