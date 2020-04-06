package com.example.spring_boot_amigoode.api;

import com.example.spring_boot_amigoode.model.Person;
import com.example.spring_boot_amigoode.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private PersonServiceImpl personServiceImpl;

    @Autowired
    public PersonController(PersonServiceImpl personServiceImpl) {
        this.personServiceImpl = personServiceImpl;
    }


             // ete front-end ic id uxarken u modely sax ira popoxutyunov kstacvi update
    @PostMapping
    public void savePerson(@Valid @NotNull @RequestBody Person person) {
        personServiceImpl.savePerson(person);
    }

                     // ete mi api -i mech 2 hat nuyn http zaprosic ka pti meky urish url unena
    @GetMapping("/all")
    public List<Person> findAllPersons() {
        return personServiceImpl.findAllPersons();
    }

    @GetMapping
    public Person findPersonById(@RequestParam("id") int id) {
        return personServiceImpl.findPersonById(id);
    }

    @DeleteMapping
    public void deletePersonById(@RequestParam("id") int id) {

        personServiceImpl.deletePersonById(id);
    }

                         // ete save in el senc json tanq nuyn dzev kashxati
    @PutMapping("/{id}")
    public void updatePersonById(@RequestBody Person person,
                                 @PathVariable("id") int id) {
        personServiceImpl.updatePersonById(id, person);
    }

                                         //HQL -ov
    @PutMapping
    public void updatePersonName(@RequestParam("id") int id,
                                 @RequestParam("name") String name) {
        personServiceImpl.updatePersonName(id, name);
    }

                                         //nativ - ov
    @PutMapping("/native/{id}")
    public void updatePersonNameById(@PathVariable("id") int id,
                                     @RequestParam("name") String name) {
        personServiceImpl.updatePersonNameById(id, name);
    }
}

