package com.stackspot.cucumber.integration.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Setter
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private ContaStatus status;

    @NotNull
    private ContaTipo tipo;

    public enum ContaStatus {
        ATIVA,
        INATIVA,
        BLOQUEADA
    }
    public enum ContaTipo {
        CORRENTE,
        POUPANCA
    }

}
