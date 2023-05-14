package com.stackspot.cucumber.integration.service;

import com.stackspot.cucumber.integration.model.Cliente;
import com.stackspot.cucumber.integration.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> getClientes(){
        return this.repository.findAll();
    }

    public Cliente getCliente(Long id){
        return this.repository.findById(id).orElse(null);
    }

    public Cliente saveCliente(Cliente client){


        return this.repository.save(client);
    }
}
