package com.example.demo.repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Person;
import com.example.demo.repo.PersonRepo;

@DataJpaTest
class PersonRepoTest {
	@Autowired
    private PersonRepo personRepo;
    private Person person;
	@BeforeEach
	void setup() {
    	person = Person.builder().personId(1001).personName("Manasi").personCity("Pune").build();
    }
    @Test
    void isPersonExitsById() {
      Person person = new Person(1001, "Manasi", "Pune");
        personRepo.save(person);
        Person actualResult = personRepo.findById(person.getPersonId()).get();
        assertThat(actualResult.getPersonId()).isNotNull();
       
    }
}
