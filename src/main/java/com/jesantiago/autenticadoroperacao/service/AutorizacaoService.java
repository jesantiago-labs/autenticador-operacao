package com.jesantiago.autenticadoroperacao.service;


import com.jesantiago.autenticadoroperacao.model.AutorizacaoModel;
import com.jesantiago.autenticadoroperacao.repository.AutorizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorizacaoService {

    @Autowired
    AutorizacaoRepository autorizacaoRepository;

    public String verificaSituacao(String idAutorizacao) {

        List<AutorizacaoModel> autorizacaoModelOptional = autorizacaoRepository.findByIdAutorizacao(idAutorizacao);

        return !autorizacaoModelOptional.isEmpty() ? autorizacaoModelOptional.get(0).getSituacaoAutorizacao().getDescricao() : null;
    }
}
