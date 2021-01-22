package com.jesantiago.autenticadoroperacao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum SituacaoAutorizacao {

    PENDENTE("PENDENTE"),
    AUTORIZADO("AUTORIZADO"),
    NEGADO("NEGADO");

    private final String descricao;

}
