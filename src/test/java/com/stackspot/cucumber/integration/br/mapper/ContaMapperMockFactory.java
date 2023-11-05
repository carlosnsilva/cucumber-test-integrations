package com.stackspot.cucumber.integration.br.mapper;

import com.stackspot.cucumber.integration.dto.ContaDTO;
import com.stackspot.cucumber.integration.model.Conta;

import static com.stackspot.cucumber.integration.model.Conta.ContaStatus.ATIVA;
import static com.stackspot.cucumber.integration.model.Conta.ContaTipo.CORRENTE;

public class ContaMapperMockFactory {

    public static ContaDTO criaContaDTOMockFactory(){
        return ContaDTO.builder()
                .status(ATIVA)
                .tipo(CORRENTE)
                .build();
    }

    public static Conta criaContaMockFactory(){
        return Conta.builder()
                .status(ATIVA)
                .tipo(CORRENTE)
                .build();
    }
}
