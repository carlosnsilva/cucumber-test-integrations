package com.stackspot.cucumber.integration.service;

import com.stackspot.cucumber.integration.model.Cliente;
import com.stackspot.cucumber.integration.repository.ClienteRepository;
import com.stackspot.cucumber.integration.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ContaRepository contaRepository;

    public List<Cliente> getClientes(){
        return this.clienteRepository.findAll();
    }

    public Cliente getCliente(Long id){
        return this.clienteRepository.findById(id).orElse(null);
    }

    public Optional<Cliente> getCliente(String cpf){
        return this.clienteRepository.findByCpf(cpf);
    }

    public Cliente saveCliente(Cliente cliente){
        this.contaRepository.save(cliente.getConta());
        return this.clienteRepository.save(cliente);
    }
}
