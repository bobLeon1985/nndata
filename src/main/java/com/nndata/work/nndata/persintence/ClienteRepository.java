package com.nndata.work.nndata.persintence;

import com.nndata.work.nndata.domain.Client;
import com.nndata.work.nndata.domain.repository.ClientRepository;
import com.nndata.work.nndata.persintence.crud.ClienteCrudRepository;
import com.nndata.work.nndata.persintence.entity.Cliente;
import com.nndata.work.nndata.persintence.entity.Persona;
import com.nndata.work.nndata.persintence.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClientRepository {

    @Autowired
    private ClienteCrudRepository  clienteCrudRepository;

    @Autowired
    private ClienteMapper mapper;

    @Override
    public List<Cliente> getAll(){
        //List<Cliente> clientes =
        return (List<Cliente>) clienteCrudRepository.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        //Cliente cliente = mapper.toCliente(client);
        return clienteCrudRepository.save(cliente);
    }

}
