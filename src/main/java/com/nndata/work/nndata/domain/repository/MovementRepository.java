package com.nndata.work.nndata.domain.repository;

import com.nndata.work.nndata.domain.dto.NewMovementData;
import com.nndata.work.nndata.domain.exceptions.InsufficientFundsException;
import com.nndata.work.nndata.domain.exceptions.InvalidMovementTypeException;
import com.nndata.work.nndata.persintence.entity.Movimientos;

public interface MovementRepository {

    public Movimientos createMovement(Long accountId, NewMovementData newMovementData) throws InsufficientFundsException, InvalidMovementTypeException;

}
