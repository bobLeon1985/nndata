package com.nndata.work.nndata.domain.repository;


import com.nndata.work.nndata.domain.Person;
import com.nndata.work.nndata.persintence.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {

    List<Persona> getAll();
    //Optional<List<Person>> getByPersonId(int personId);
    Persona save (Persona persona);
    //void delete (long personId);

}
