package com.nndata.work.nndata.persintence;

import com.nndata.work.nndata.domain.dto.NewMovementData;
import com.nndata.work.nndata.domain.exceptions.InsufficientFundsException;
import com.nndata.work.nndata.domain.exceptions.InvalidMovementTypeException;
import com.nndata.work.nndata.domain.repository.MovementRepository;
import com.nndata.work.nndata.persintence.crud.CuentaCrudRepository;
import com.nndata.work.nndata.persintence.crud.MovimientoCrudRepository;
import com.nndata.work.nndata.persintence.entity.Cuenta;
import com.nndata.work.nndata.persintence.entity.Movimientos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class MovimientoRepository implements MovementRepository {

    @Autowired
    private MovimientoCrudRepository movimientoCrudRepository;

    @Autowired
    private CuentaCrudRepository cuentaCrudRepository;


    @Override
    public Movimientos createMovement(Long accountId, NewMovementData newMovementData) throws InsufficientFundsException, InvalidMovementTypeException {
        Optional<Cuenta> acc = cuentaCrudRepository.findById(accountId);
        Movimientos mv = newMovementData.toMovement();
        return saveMovement(new Cuenta(), mv);
    }

    @Transactional
    private Movimientos saveMovement(Cuenta account, Movimientos movement) throws InsufficientFundsException {
        account.applyMovement(movement);
        movement.setCuentaid(account);
        cuentaCrudRepository.save(account);
        return movimientoCrudRepository.save(movement);
    }
}
