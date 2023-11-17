package com.sec2.ahmad.service;

import com.sec2.ahmad.model.Person;
import com.sec2.ahmad.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person update(Person person) {
        Person updatePerson = personRepository.findById(person.getId())
                .orElseThrow(() -> new RuntimeException("person not found"));//show in console
        updatePerson.setName(person.getName());
        updatePerson.setLastname(person.getLastname());
        return personRepository.save(updatePerson);

    }

    public Person findById(Person person) {
        return personRepository.findById(person.getId())
                .orElseThrow(() -> new RuntimeException("person not found"));

    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void deleteById(Person person) {
        personRepository.deleteById(person.getId());
    }
}