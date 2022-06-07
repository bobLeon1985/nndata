package com.nndata.work.nndata.domain.service;

import com.nndata.work.nndata.domain.Client;
import com.nndata.work.nndata.domain.Person;
import com.nndata.work.nndata.domain.repository.ClientRepository;
import com.nndata.work.nndata.domain.repository.PersonRepository;
import com.nndata.work.nndata.persintence.entity.Cliente;
import com.nndata.work.nndata.persintence.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PersonRepository personRepository;

    public List<Cliente> getAllc(){
        return clientRepository.getAll();
    }

    public List<Persona> getAll(){
        return personRepository.getAll();
    }

    public Persona save (Persona persona){
        return personRepository.save(persona);
    }
}
