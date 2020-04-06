package com.example.spring_boot_amigoode.repository;

import com.example.spring_boot_amigoode.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

                       // hp query dimuma model in
    @Modifying // ete bazayum popoxutyuna linelu ampayman dnum enq Modifying
    @Transactional
    @Query(value = "update Person u set u.name=:name where u.id=:id")
    void updatePersonName(@Param("id") int id,
                         @Param("name") String name);


                      // native query n dimuma bazain
    @Modifying
    @Transactional
    @Query(value = "update persons set name=:name where id=:id", nativeQuery = true)
    void updatePersonNameById(@Param("id") int id,
                              @Param("name") String name);
}
