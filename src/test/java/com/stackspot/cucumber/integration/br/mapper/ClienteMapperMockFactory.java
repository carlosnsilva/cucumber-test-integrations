package com.stackspot.cucumber.integration.br.mapper;

import com.stackspot.cucumber.integration.model.*;
import com.stackspot.cucumber.integration.dto.*;
public class ClienteMapperMockFactory {

    public static ClienteDTO clienteMockFactory(){
        return ClienteDTO.builder()
                .id(2L)
                .cpf("000.000.000.00")
                .nome("Testando da Silva")
                .email("testando@email.com")
                .conta(criarContaMockFactory()).build();
    }

    public static ContaDTO criarContaMockFactory(){
        return ContaDTO.builder()
                .id(1L)
                .status(Conta.ContaStatus.ATIVA)
                .tipo(Conta.ContaTipo.CORRENTE)
                .build();
    }
}
