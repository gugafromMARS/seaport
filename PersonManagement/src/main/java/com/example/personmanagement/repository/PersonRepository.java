package com.example.personmanagement.repository;

import com.example.personmanagement.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Person person){
        entityManager.persist(person);
    }

    public Person getByCC(int cc){
        List<Person> personList = entityManager.createQuery("FROM Person p WHERE p.cc = :cc", Person.class)
                .setParameter("cc", cc)
                .getResultList();
        if (personList.isEmpty()){
            return null;
        }
        return personList.get(0);
    }
}
