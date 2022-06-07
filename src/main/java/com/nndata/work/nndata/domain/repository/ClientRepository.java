package com.nndata.work.nndata.domain.repository;

import com.nndata.work.nndata.domain.Client;
import com.nndata.work.nndata.domain.Person;
import com.nndata.work.nndata.persintence.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    List<Cliente> getAll();

   // Optional<List<Client>> getByClientId(long personId);

    Cliente save (Cliente cliente);

    //void delete (long clientId);
}
