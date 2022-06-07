package com.nndata.work.nndata.web.controller;

import com.nndata.work.nndata.domain.service.CuentaService;
import com.nndata.work.nndata.persintence.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @PostMapping("/save")
    public ResponseEntity<Cuenta> save(@RequestBody Cuenta cuenta) {
        return new ResponseEntity<>(cuentaService.save(cuenta), HttpStatus.CREATED);
    }

}
