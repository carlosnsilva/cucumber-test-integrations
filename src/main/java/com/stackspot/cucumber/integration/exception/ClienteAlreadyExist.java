package com.stackspot.cucumber.integration.exception;

public class ClienteAlreadyExist extends RuntimeException {

    public ClienteAlreadyExist(){
        super("Cliente existente na base de dados");
    }

}
