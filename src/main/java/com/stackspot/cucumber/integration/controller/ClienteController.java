package com.stackspot.cucumber.integration.controller;

import com.stackspot.cucumber.integration.model.Cliente;
import com.stackspot.cucumber.integration.service.ClienteService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Cliente> getAll(){
        return service.getClientes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Cliente getCLient(@NotNull @PathVariable("id") Long id){
        return service.getCliente(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cliente createClient(Cliente client){
        return service.saveCliente(client);
    }


}
