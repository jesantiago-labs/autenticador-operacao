package com.jesantiago.autenticadoroperacao.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_AUT_AUTORIZACAO")
@Data @AllArgsConstructor @NoArgsConstructor
public class AutorizacaoModel {

    @Id
    @Column(name = "AUT_ID")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "AUT_ID_AUTORIZACAO")
    private String idAutorizacao;

    @Column(name = "AUT_NOME_SERVICO")
    private String nomeServico;

    @Column(name = "AUT_DT_SOLICITACAO")
    private LocalDate dataSolicitacao;

    @Column(name = "AUT_ID_CLIENTE")
    private String idCliente;

    @Column(name = "AUT_DS_TOKEN")
    private String token;

    @Column(name = "AUT_DS_MENSAGEM_AUTORIZACAO")
    private String mensagemAutorizacao;

    @Column(name = "AUT_ST_AUTORIZACAO")
    private SituacaoAutorizacao situacaoAutorizacao;

}