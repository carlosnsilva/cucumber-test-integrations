package com.stackspot.cucumber.integration.dto;

import com.stackspot.cucumber.integration.model.Conta;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ContaDTO implements Serializable {

    private Long id;

    private Conta.ContaStatus status;

    @NotNull
    private Conta.ContaTipo tipo;

}
