package com.sec2.ahmad.controller;

import com.sec2.ahmad.model.Person;
import com.sec2.ahmad.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {


    private PersonServiceImpl personServiceImpl;

    public PersonController(PersonServiceImpl personServiceImpl) {
        this.personServiceImpl = personServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return ResponseEntity.ok(personServiceImpl.save(person));
    }

    @PutMapping
    public ResponseEntity<Person> update(@RequestBody Person person) {
        return ResponseEntity.ok(personServiceImpl.update(person));
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> findById(Person person) {
        return ResponseEntity.ok(personServiceImpl.findById(person));
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(personServiceImpl.findAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(Person person) {
        personServiceImpl.deleteById(person);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{name}/{lastname}")
    public ResponseEntity<Person> findByNameAndLastname(@PathVariable String name, @PathVariable String lastname) {
        return ResponseEntity.ok(personServiceImpl.findByNameAndLastname(name, lastname));
    }

}
