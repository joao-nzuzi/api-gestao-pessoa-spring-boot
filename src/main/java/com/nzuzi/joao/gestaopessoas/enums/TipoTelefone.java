package com.nzuzi.joao.gestaopessoas.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {
    CASA("Casa"),
    PESSOAL("Pessoal"),
    TRABALHO("Trabalho");

    private final String descricao;
}
