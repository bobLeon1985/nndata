package com.nndata.work.nndata.domain.repository;

import com.nndata.work.nndata.domain.Client;
import com.nndata.work.nndata.domain.Person;
import com.nndata.work.nndata.domain.dto.ClientItem;
import com.nndata.work.nndata.domain.exceptions.BadRequestException;
import com.nndata.work.nndata.persintence.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    public Iterable<ClientItem> findAll();

    public void update(Cliente client) throws BadRequestException;

    public Long save(Cliente cliente) throws BadRequestException;

    public void delete(Long clientId);
}
