package com.stackspot.cucumber.integration.controller;

import com.stackspot.cucumber.integration.dto.ClienteDTO;
import com.stackspot.cucumber.integration.mapper.ClienteMapper;
import com.stackspot.cucumber.integration.model.Cliente;
import com.stackspot.cucumber.integration.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;
    private final ClienteMapper clienteMapper;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Cliente> getAll(){
        return service.getClientes();
    }

    @GetMapping("/{cpf}")
    @ResponseStatus(code = HttpStatus.OK)
    public Cliente getCliente(@NotNull @PathVariable("cpf") String cpf){
        return service.getCliente(cpf);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cliente createCliente(@Validated @RequestBody ClienteDTO clienteDTO){
        var cliente = clienteMapper.toCliente(clienteDTO);
        return service.saveCliente(cliente);
    }
    
}
