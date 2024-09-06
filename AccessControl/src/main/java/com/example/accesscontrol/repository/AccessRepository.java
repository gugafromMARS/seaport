package com.example.accesscontrol.repository;


import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Access;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Stateless
public class AccessRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Access access){
        entityManager.persist(access);
    }

    @Transactional
    public void update(Access access){
        entityManager.merge(access);
    }

    public Access getAccess(int nif){
        return entityManager
                .createQuery("FROM Access a JOIN a.personDto p where p.nif = :nif", Access.class)
                .setParameter("nif", nif)
                .getSingleResult();
    }


}
