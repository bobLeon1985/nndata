package com.nndata.work.nndata.persintence;

import com.nndata.work.nndata.domain.Client;
import com.nndata.work.nndata.domain.Person;
import com.nndata.work.nndata.domain.repository.PersonRepository;
import com.nndata.work.nndata.persintence.crud.PersonaCrudRepository;
import com.nndata.work.nndata.persintence.entity.Cliente;
import com.nndata.work.nndata.persintence.entity.Persona;
import com.nndata.work.nndata.persintence.mapper.ClienteMapper;
import com.nndata.work.nndata.persintence.mapper.PersonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonaRepository implements PersonRepository {

    @Autowired
    private PersonaCrudRepository personaCrudRepository;

    @Autowired
    private PersonaMapper mapper;

    @Override
    public List<Persona> getAll(){
        //List<Persona> personas =
        return (List<Persona>) personaCrudRepository.findAll();
    }

    public Optional<Persona> getProducto (long idPersona){
        return personaCrudRepository.findById(idPersona);
    }

    @Override
    public Persona save(Persona persona) {
        //Persona persona = mapper.toPersona(persona);
        return personaCrudRepository.save(persona);
    }
}
