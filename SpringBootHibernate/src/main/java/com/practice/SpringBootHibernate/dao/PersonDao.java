package com.practice.SpringBootHibernate.dao;

import java.util.Collection;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practice.SpringBootHibernate.model.Person;

@Repository
@Transactional
public class PersonDao {
	@Autowired
	private SessionFactory factory;
	public Session getSession() {
		Session session = factory.getCurrentSession();
		if(session == null) {
			session = factory.openSession();
		}
	return session;	
	}
	public void saveperson(Person person) {
		getSession().save(person);
	}
	
	@SuppressWarnings("deprecation")
	public List<Person> getPersons(){
		return getSession().createCriteria(Person.class).list();
	}
	public String deleteperson(int id) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		Session session = factory.openSession();
		org.hibernate.Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Person.class);
		criteria.add(Restrictions.eq("id", id));
		Person person = (Person) criteria.uniqueResult();
		session.delete(person);
		transaction.commit();
		return person.getName() + "is deleted!";
	}
}
