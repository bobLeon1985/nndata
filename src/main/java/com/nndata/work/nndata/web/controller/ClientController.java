package com.nndata.work.nndata.web.controller;

import com.nndata.work.nndata.domain.dto.ClientItem;
import com.nndata.work.nndata.domain.exceptions.BadRequestException;
import com.nndata.work.nndata.domain.service.ClientService;
import com.nndata.work.nndata.persintence.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<ClientItem> findAll() {
        return clientService.findAll();
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateClient(@PathVariable Long id, @RequestBody Cliente client) {
        assert(id == client.getClienteid());
        try {
            clientService.update(client);
            return new ResponseEntity("\"Cliente actualizado correctamente\"", HttpStatus.CREATED);
        } catch (BadRequestException e) {
            return new ResponseEntity<String>("\""+e.getMessage()+"\"", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    private ResponseEntity<String> save(@RequestBody Cliente cliente) throws BadRequestException {
        try {
            Long id = clientService.save(cliente);
            return new ResponseEntity("{ \"id\": " + id + " }", HttpStatus.CREATED);
        } catch (BadRequestException e) {
            return new ResponseEntity<String>("\"" + e.getMessage() + "\"", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        try {
            clientService.deleteClient(id);
            return new ResponseEntity("\"Cliente eliminado correctamente\"",HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("\"Error al eliminar cliente: "+e.getMessage()+"\"", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
