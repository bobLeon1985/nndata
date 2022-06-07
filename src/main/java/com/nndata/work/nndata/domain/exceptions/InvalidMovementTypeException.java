package com.nndata.work.nndata.domain.exceptions;

public class InvalidMovementTypeException extends NndataException {

    public InvalidMovementTypeException(String invalidType){
        super("'"+invalidType+"' is not a valid movement type");
    }
}
