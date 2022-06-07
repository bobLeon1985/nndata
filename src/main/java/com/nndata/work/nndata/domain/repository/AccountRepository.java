package com.nndata.work.nndata.domain.repository;

import com.nndata.work.nndata.persintence.entity.Cliente;
import com.nndata.work.nndata.persintence.entity.Cuenta;

import java.util.List;

public interface AccountRepository {

    List<Cuenta> getAll();

    Cuenta save (Cuenta cuenta);
}
