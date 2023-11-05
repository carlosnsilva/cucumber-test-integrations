package com.stackspot.cucumber.integration.br.service;

import com.stackspot.cucumber.integration.model.Cliente;
import com.stackspot.cucumber.integration.repository.ClienteRepository;
import com.stackspot.cucumber.integration.repository.ContaRepository;
import com.stackspot.cucumber.integration.service.ClienteService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.stackspot.cucumber.integration.br.mapper.ContaMapperMockFactory.criaContaMockFactory;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ContaRepository contaRepository;

    @InjectMocks
    private ClienteService clienteService;


}
