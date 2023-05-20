package com.stackspot.cucumber.integration.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class ClienteDTO  {
    private Long id;
    @NotNull
    private String cpf;
    @NotNull
    private String nome;
    @NotNull
    private String email;
    private ContaDTO conta;

}
