package com.nndata.work.nndata.domain.service;

import com.nndata.work.nndata.domain.dto.NewMovementData;
import com.nndata.work.nndata.domain.exceptions.InsufficientFundsException;
import com.nndata.work.nndata.domain.exceptions.InvalidMovementTypeException;
import com.nndata.work.nndata.domain.repository.MovementRepository;
import com.nndata.work.nndata.persintence.entity.Movimientos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementService {

    @Autowired
    private MovementRepository movementRepository;

    public Movimientos createMovement(Long accountId, NewMovementData newMovementData) throws InsufficientFundsException, InvalidMovementTypeException {
        return movementRepository.createMovement(accountId, newMovementData);
    }


}
