package com.nndata.work.nndata.web.controller;

import com.nndata.work.nndata.domain.Client;
import com.nndata.work.nndata.domain.Person;
import com.nndata.work.nndata.domain.service.ClientService;
import com.nndata.work.nndata.persintence.entity.Cliente;
import com.nndata.work.nndata.persintence.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<List<Persona>> getAll() {
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/allc")
    public ResponseEntity<List<Cliente>> getAllC() {
        return new ResponseEntity<>(clientService.getAllc(), HttpStatus.OK);
    }

    @PostMapping("/save")
    private ResponseEntity<Persona> save (@RequestBody Persona persona){
        return new ResponseEntity<>(clientService.save(persona), HttpStatus.CREATED);
    }

    /*public List<Client> getAll() {
        return clientService.getAll();
    }cls

    public Client save(Client client) {
        return clientService.save(client);
    }

    public boolean delete(long clientId) {
        return clientService.delete(clientId);
    }*/
}
