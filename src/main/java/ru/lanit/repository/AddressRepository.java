package ru.lanit.repository;

import org.springframework.stereotype.Repository;
import ru.lanit.model.Address;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AddressRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Address address) {
        em.persist(address);
        em.flush();
    }
}
