package com.nndata.work.nndata.persintence;

import com.nndata.work.nndata.domain.repository.AccountRepository;
import com.nndata.work.nndata.persintence.crud.CuentaCrudRepository;
import com.nndata.work.nndata.persintence.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CuentaRepository implements AccountRepository {

    @Autowired
    private CuentaCrudRepository cuentaCrudRepository;

    @Override
    public List<Cuenta> getAll(){
        //List<Persona> personas =
        return (List<Cuenta>) cuentaCrudRepository.findAll();
    }

    @Override
    public Cuenta save(Cuenta cuenta) {
        //Cliente cliente = mapper.toCliente(client);
        return cuentaCrudRepository.save(cuenta);
    }
}
