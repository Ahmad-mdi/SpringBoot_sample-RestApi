package com.sec2.ahmad.repository;

import com.sec2.ahmad.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
