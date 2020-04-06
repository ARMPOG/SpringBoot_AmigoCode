package com.example.spring_boot_amigoode.service.impl;

import com.example.spring_boot_amigoode.model.Person;
import com.example.spring_boot_amigoode.repository.PersonRepository;
import com.example.spring_boot_amigoode.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person findPersonById(int id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePersonById(int id) {
        personRepository.deleteById(id);
    }

    @Override
    public void updatePersonById(int id, Person person) {
        person.setId(id);
        personRepository.save(person);
    }

    @Override
    public void updatePersonName(int id, String name) {
        personRepository.updatePersonName(id, name);
    }

    @Override
    public void updatePersonNameById(int id, String name) {
        personRepository.updatePersonNameById(id,name);
    }
}
