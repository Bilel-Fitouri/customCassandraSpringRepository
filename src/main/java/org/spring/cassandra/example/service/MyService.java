package org.spring.cassandra.example.service;

import org.spring.cassandra.example.dto.Person;
import org.spring.cassandra.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bfitouri on 26/10/16.
 */
@Service
public class MyService {

    private final PersonRepository personRepository;

    @Autowired
    public MyService(final PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person getPersonByName(String name){
        return personRepository.findOne(name);
    }
}
