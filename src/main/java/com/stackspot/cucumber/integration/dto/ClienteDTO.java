package com.stackspot.cucumber.integration.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteDTO  {
    private Long id;
    @NotNull
    private String cpf;
    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    private ContaDTO conta;

}
