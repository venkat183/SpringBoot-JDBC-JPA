package com.venkat.database.databasejdbcjpa.jpa;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.venkat.database.databasejdbcjpa.entity.Person;


@Repository
@Transactional
public class PersonJpaRepository {
	
	@PersistenceContext
	EntityManager em;

	public Person getById(int id) {
		return em.find(Person.class, id);
	}
	
	public Person insertPerson(Person person) {
		return em.merge(person);
	}

	public Person updatePerson(Person person) {
		return em.merge(person);
	}
	
	public void deleteById(int id) {
		Person person = getById(id);
		em.remove(person);
	}
	public List<Person> findAll() {
		 TypedQuery<Person> createNamedQuery = em.createNamedQuery("find_all", Person.class);
		 return createNamedQuery.getResultList();
	}

}
