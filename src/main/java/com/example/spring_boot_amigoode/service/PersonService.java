package com.example.spring_boot_amigoode.service;

import com.example.spring_boot_amigoode.model.Person;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonService {

     void savePerson(Person person);

     List<Person> findAllPersons ();

     Person findPersonById(int id);

     void deletePersonById(int id);

     void updatePersonById(int id, Person person);


     // HP query
     void updatePersonName(int id , String name);

     // native
     void updatePersonNameById(int id, String name);

}
