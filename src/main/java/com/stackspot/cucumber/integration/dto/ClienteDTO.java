package com.stackspot.cucumber.integration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO  {
    private Long id;
    @NotNull
    @Min(12)
    @Max(12)
    private String cpf;
    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    private ContaDTO conta;

}
