package com.jesantiago.autenticadoroperacao.repository;

import com.jesantiago.autenticadoroperacao.model.AutorizacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorizacaoRepository extends JpaRepository<AutorizacaoModel, Long> {

    List<AutorizacaoModel> findByIdAutorizacao(String idAutorizacao);
}
