package com.practice.SpringBootHibernate.controller;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.SpringBootHibernate.dao.PersonDao;
import com.practice.SpringBootHibernate.model.Person;

@RestController
@RequestMapping("/orm")
public class PersonController {
	@Autowired
	private PersonDao dao;
	
	@PostMapping("/savePerson")
	public String save(@RequestBody Person person) {
		dao.saveperson(person);
		return "saved successfully!!";
	}
	
	@GetMapping("/getAllPersons")
	public List<Person> getAllPerson(){
		return dao.getPersons();
	} 
	@DeleteMapping("/deletePersons/{id}")
	public String delete(@PathVariable int id) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		dao.deleteperson(id);
		return "deleted successfully!";
	}
	
}
