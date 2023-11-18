package com.sec2.ahmad.repository;

import com.sec2.ahmad.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {


   Optional<Person> findByNameAndLastname(String name, String lastname);
}
