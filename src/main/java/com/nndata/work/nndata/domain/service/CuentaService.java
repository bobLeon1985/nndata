package com.nndata.work.nndata.domain.service;

import com.nndata.work.nndata.domain.repository.AccountRepository;
import com.nndata.work.nndata.persintence.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {

    @Autowired
    private AccountRepository cuentaRepository;

    public List<Cuenta> getAllc(){
        return cuentaRepository.getAll();
    }

    public Cuenta save (Cuenta cuenta){
        return cuentaRepository.save(cuenta);
    }

}
