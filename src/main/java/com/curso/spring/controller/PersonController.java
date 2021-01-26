package com.curso.spring.controller;

import com.curso.spring.model.Person;
import com.curso.spring.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices personServices;

    @GetMapping("/{id}")
    public Person getById(@PathVariable("id") String id){
        return personServices.getById(id);
    }

    @GetMapping()
    public List<Person> getAll(){
        return personServices.getAll();
    }
}
