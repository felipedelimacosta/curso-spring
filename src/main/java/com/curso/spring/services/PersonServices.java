package com.curso.spring.services;

import com.curso.spring.model.Person;
import com.curso.spring.repository.PersonRepository;
import com.curso.spring.vo.PersonVO;
import com.curso.spring.exception.PersonNotFoundException;
import com.curso.spring.converter.DozerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private PersonRepository personRepository;

    public PersonVO create(PersonVO person){

        Person entity = DozerConverter.parseObject(person, Person.class);
        PersonVO vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        //personRepository.save(person);
        return vo;
    }

    public PersonVO update(PersonVO person){
        Person newPerson = personRepository.findById(person.getId())
                .orElseThrow(() -> new PersonNotFoundException("No records found for this id"));
        newPerson.setFirstName(person.getFirstName());
        newPerson.setLastName(person.getLastName());
        newPerson.setAddress(person.getAddress());
        newPerson.setGender(person.getGender());

        PersonVO vo = DozerConverter.parseObject(personRepository.save(newPerson), PersonVO.class);
        return vo;
    }

    public ResponseEntity<PersonVO> delete(Long id){
        Person deletePerson = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("No records found for this id"));

        personRepository.delete(deletePerson);
        //return ResponseEntity.ok().body(deletePerson);
        return null;

    }

    public PersonVO getById(Long id){

        Person entity =  personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("No records found for this id"));
        PersonVO vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public List<PersonVO> getAll(){
        return DozerConverter.parseListObjects(personRepository.findAll(), PersonVO.class);

    }
}
