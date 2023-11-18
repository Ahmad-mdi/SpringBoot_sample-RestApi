package com.sec2.ahmad.service;

import com.sec2.ahmad.model.Person;
import com.sec2.ahmad.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }
    @Override
    public Person update(Person person) {
        Person updatePerson = personRepository.findById(person.getId())
                .orElseThrow(() -> new RuntimeException("person not found"));//show in console
        updatePerson.setName(person.getName());
        updatePerson.setLastname(person.getLastname());
        return personRepository.save(updatePerson);

    }
    @Override
    public Person findById(Person person) {
        return personRepository.findById(person.getId())
                .orElseThrow(() -> new RuntimeException("person not found"));

    }
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
    @Override
    public void deleteById(Person person) {
        personRepository.deleteById(person.getId());
    }
    @Override
    public Person findByNameAndLastname(String name, String lastname){
        return personRepository.findByNameAndLastname(name, lastname)
                .orElseThrow(()-> new RuntimeException("not found person"));
    }
}