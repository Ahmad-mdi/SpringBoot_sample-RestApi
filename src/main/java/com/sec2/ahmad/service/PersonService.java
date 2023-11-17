package com.sec2.ahmad.service;

import com.sec2.ahmad.model.Person;

import java.util.List;

public interface PersonService{
    Person save(Person person);
    Person update(Person person);
    Person findById(Person person);
    List<Person> findAll();
    void deleteById(Person person);


}
