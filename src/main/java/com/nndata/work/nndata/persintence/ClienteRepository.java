package com.nndata.work.nndata.persintence;

import com.nndata.work.nndata.domain.dto.ClientItem;
import com.nndata.work.nndata.domain.exceptions.BadRequestException;
import com.nndata.work.nndata.domain.repository.ClientRepository;
import com.nndata.work.nndata.persintence.crud.ClienteCrudRepository;
import com.nndata.work.nndata.persintence.entity.Cliente;
import com.nndata.work.nndata.persintence.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class ClienteRepository implements ClientRepository {

    @Autowired
    private ClienteCrudRepository  clienteCrudRepository;

    @Autowired
    private ClienteMapper mapper;

    @Override
    public Iterable<ClientItem> findAll() {
        Iterable<Cliente> clients = clienteCrudRepository.findAll();
        return StreamSupport
                .stream(clients.spliterator(), false)
                .map(completeClient -> new ClientItem(completeClient))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Cliente client) throws BadRequestException {
        if(client.getClienteid() == null)
            throw new BadRequestException("Id is required when updating");
        if(client.getCuentaList() != null)
            throw new BadRequestException("No need to send accounts when updating a client");
        clienteCrudRepository.save(client);
    }

    @Override
    public Long save(Cliente client) throws BadRequestException {
        //Cliente cliente = mapper.toCliente(client);
        if(client.getClienteid()!=null || client.getCuentaList()!=null)
            throw new BadRequestException("No need to set id or accounts when creating a client");
        return clienteCrudRepository.save(client).getClienteid();
    }

    @Override
    public void delete(Long id) {
        clienteCrudRepository.deleteById(id);
    }

}
