package com.curso.spring.controller;

import com.curso.spring.vo.PersonVO;
import com.curso.spring.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices personServices;


    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    public PersonVO getById(@PathVariable("id") Long id){
        return personServices.getById(id);
    }

    @GetMapping(produces = {"application/json", "application/xml"} )
    public List<PersonVO> getAll(){
        return personServices.getAll();
    }

    @PostMapping(value = "/create", produces = {"application/json", "application/xml"}, consumes = {"application/json", "application/xml"} )
    public PersonVO create(@RequestBody PersonVO person){
        return personServices.create(person);
    }

    @PutMapping(value = "/update", produces = {"application/json", "application/xml"}, consumes = {"application/json", "application/xml"})
    public PersonVO update(@RequestBody PersonVO person){
        return personServices.update(person);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PersonVO> delete(@PathVariable("id") Long id){
        return personServices.delete(id);
    }

}
