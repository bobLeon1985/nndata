package com.nndata.work.nndata.domain.exceptions;

public class InsufficientFundsException extends NndataException {

    public InsufficientFundsException(Long accountId) {
        super("The account with id '"+accountId+"' has insufficient funds to perform the movement");
    }

}

