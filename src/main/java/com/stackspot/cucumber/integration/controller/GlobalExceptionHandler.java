package com.stackspot.cucumber.integration.controller;

import com.stackspot.cucumber.integration.exception.ClienteNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GlobalExceptionHandler {
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cliente nao encontrado!")
    @ExceptionHandler(ClienteNotFound.class)
    void clienteNotFound(ClienteNotFound exception) {}
}