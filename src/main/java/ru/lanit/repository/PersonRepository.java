package ru.lanit.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Person> getList() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> rootEntry = cq.from(Person.class);
        cq.orderBy(cb.asc(rootEntry.get("fullName")));

        return em.createQuery(cq).getResultList();
    }

    public Person getById(int id) {
        return em.find(Person.class, id);
    }

    public void save(Person person) {
        em.persist(person);
        em.flush();
    }
}
