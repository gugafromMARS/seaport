package com.example.personmanagement.repository;

import com.example.personmanagement.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
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
