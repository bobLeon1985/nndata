package com.nndata.work.nndata.domain.service;

import com.nndata.work.nndata.domain.exceptions.ClientDoesntExistException;
import com.nndata.work.nndata.domain.repository.AccountRepository;
import com.nndata.work.nndata.persintence.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CuentaService {

    @Autowired
    private AccountRepository cuentaRepository;

    public Cuenta createEmptyAccountForClientWithId(Long clientId) throws ClientDoesntExistException {
        return cuentaRepository.saveEmptyAccountForClientWithId(clientId);
    }

    public List<AccountReport> filterAccounts(Long clientId, Date start, Date end) throws ClientDoesntExistException{
        return cuentaRepository.filterAccounts(clientId, start, end);
    }

}
