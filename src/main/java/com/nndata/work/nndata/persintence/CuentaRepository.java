package com.nndata.work.nndata.persintence;

import com.nndata.work.nndata.domain.dto.AccountReport;
import com.nndata.work.nndata.domain.exceptions.ClientDoesntExistException;
import com.nndata.work.nndata.domain.repository.AccountRepository;
import com.nndata.work.nndata.persintence.crud.ClienteCrudRepository;
import com.nndata.work.nndata.persintence.crud.CuentaCrudRepository;
import com.nndata.work.nndata.persintence.entity.Cliente;
import com.nndata.work.nndata.persintence.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CuentaRepository implements AccountRepository {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;


    @Autowired
    private CuentaCrudRepository cuentaCrudRepository;

    @Override
    public List<Cuenta> getAll(){
        //List<Persona> personas =
        return (List<Cuenta>) cuentaCrudRepository.findAll();
    }

    @Override
    public Cuenta saveEmptyAccountForClientWithId(Long clientId) throws ClientDoesntExistException {
        Optional<Cliente> client = clienteCrudRepository.findById(clientId);

        if(client == null){
            throw new ClientDoesntExistException(clientId);
        } else {
            Cuenta acc = new Cuenta(client);
            return cuentaCrudRepository.save(acc);
        }
    }

    @Override
    public List<AccountReport> filterAccounts(Long clientId, Date start, Date end) throws ClientDoesntExistException {
        Optional<Cliente> client = clienteCrudRepository.findById(clientId);
        Cliente cli = client.get();
        if(client == null){
            throw new ClientDoesntExistException(clientId);
        } else {
            return cli.getCuentaList()
                    .stream()
                    .map(account -> AccountReport.fromAccount(account, start, end))
                    .collect(Collectors.toList());
        }
    }
}
