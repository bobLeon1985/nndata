package com.nndata.work.nndata.domain.exceptions;

public class ClientDoesntExistException extends NndataException {

    public ClientDoesntExistException(Long clientId){
        super("The client with id "+clientId+" doesn't exist");
    }
}
