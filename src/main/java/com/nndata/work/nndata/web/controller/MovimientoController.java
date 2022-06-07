package com.nndata.work.nndata.web.controller;

import com.nndata.work.nndata.domain.dto.NewMovementData;
import com.nndata.work.nndata.domain.exceptions.InsufficientFundsException;
import com.nndata.work.nndata.domain.exceptions.InvalidMovementTypeException;
import com.nndata.work.nndata.domain.repository.MovementRepository;
import com.nndata.work.nndata.persintence.entity.Movimientos;
import com.nndata.work.nndata.persintence.entity.TipoMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/movimiento")
public class MovimientoController {

    @Autowired
    private MovementRepository movementService;

    @RequestMapping(value = "/movimientos/{accountId}/movements", method = RequestMethod.POST)
    public ResponseEntity<String> createMovement( @PathVariable Long accountId, @RequestBody NewMovementData newMovementData) {
        if(newMovementData.getSaldo() == null || newMovementData.getTipoMovimiento() == null){
            return new ResponseEntity("\"Required 'ammount' and 'type' fields\"", HttpStatus.BAD_REQUEST);
        }
        if(newMovementData.getSaldo().compareTo(BigDecimal.ZERO) <= 0 && newMovementData.getTipoMovimiento().equals(TipoMovimiento.DEBIT))
            return new ResponseEntity<String>("\"Saldo no disponible\"", HttpStatus.BAD_REQUEST);
        try {
            Movimientos createdMovement = movementService.createMovement(accountId, newMovementData);
            return new ResponseEntity(createdMovement, HttpStatus.CREATED);
        } catch (InvalidMovementTypeException e) {
            return new ResponseEntity("\""+e.getMessage()+"\"", HttpStatus.BAD_REQUEST);
        } catch (InsufficientFundsException e) {
            return new ResponseEntity("\""+e.getMessage()+"\"", HttpStatus.BAD_REQUEST);
        }
    }
}
