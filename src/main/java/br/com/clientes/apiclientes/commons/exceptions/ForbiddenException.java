package br.com.clientes.apiclientes.commons.exceptions;

public class ForbiddenException extends  RuntimeException{

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

}
