package com.nndata.work.nndata.domain.service;

import com.nndata.work.nndata.domain.dto.ClientItem;
import com.nndata.work.nndata.domain.exceptions.BadRequestException;
import com.nndata.work.nndata.domain.repository.ClientRepository;
import com.nndata.work.nndata.persintence.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public void update(Cliente cliente) throws BadRequestException
    {
        clientRepository.update(cliente);
    }

    public Iterable<ClientItem> findAll() {
        return clientRepository.findAll();
    }

    public Long save (Cliente cliente) throws BadRequestException {
        return clientRepository.save(cliente);
    }

    public void deleteClient(Long id){
        clientRepository.delete(id);
    }
}
