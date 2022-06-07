package com.nndata.work.nndata.web.controller;

import com.nndata.work.nndata.domain.exceptions.ClientDoesntExistException;
import com.nndata.work.nndata.domain.service.CuentaService;
import com.nndata.work.nndata.persintence.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cuentas")
public class CuentaController {
    @Autowired
    private CuentaService accountService;

    @RequestMapping(value = "/cuentas/{clientId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<String> createClientAccount(@PathVariable Long clientId) {
        try {
            Cuenta created = accountService.createEmptyAccountForClientWithId(clientId);
            return new ResponseEntity("{ \"id\" : "+created.getNumeroCuenta()+" }", HttpStatus.CREATED);
        } catch (ClientDoesntExistException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("\"Error creando cuenta: "+e.getMessage()+"\"", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
