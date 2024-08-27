package com.example.billing.repository;


import com.example.billing.model.Invoice;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class InvoiceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Invoice invoice){
        entityManager.persist(invoice);
    }


    public Invoice getById(Long id){
        return entityManager.createQuery("FROM Invoice i WHERE i.id = :id", Invoice.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<Invoice> getByNif(int nif){
        List<Invoice> invoiceList = entityManager.createQuery("FROM Invoice i WHERE i.personNif = :nif", Invoice.class)
                .setParameter("nif", nif)
                .getResultList();
        if(invoiceList.isEmpty()){
            throw new WebApplicationException("No invoices found", Response.Status.NOT_FOUND);
        }
        return invoiceList;
    }

}
