package com.curso.spring.services;

import com.curso.spring.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    public Person getById(String id){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Felipe");
        person.setLastName("Costa");
        person.setAddress("Jaguaruana-Ceara");
        person.setGender("Male");

        return person;
    }

    public List<Person> getAll(){
        List<Person> person = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            Person mockPerson = new Person();
            mockPerson.setId(counter.incrementAndGet());
            mockPerson.setFirstName("Felipe");
            mockPerson.setLastName("Costa");
            mockPerson.setAddress("Jaguaruana-Ceara");
            mockPerson.setGender("Male");

            person.add(mockPerson);
        }


        return person;
    }
}
