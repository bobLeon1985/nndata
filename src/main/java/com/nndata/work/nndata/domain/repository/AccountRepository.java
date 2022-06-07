package com.nndata.work.nndata.domain.repository;

import com.nndata.work.nndata.domain.dto.AccountReport;
import com.nndata.work.nndata.domain.exceptions.ClientDoesntExistException;
import com.nndata.work.nndata.persintence.entity.Cliente;
import com.nndata.work.nndata.persintence.entity.Cuenta;

import java.util.Date;
import java.util.List;

public interface AccountRepository {

    List<Cuenta> getAll();

    public Cuenta saveEmptyAccountForClientWithId(Long clientId) throws ClientDoesntExistException;

    public List<AccountReport> filterAccounts(Long clientId, Date start, Date end) throws ClientDoesntExistException;
}
