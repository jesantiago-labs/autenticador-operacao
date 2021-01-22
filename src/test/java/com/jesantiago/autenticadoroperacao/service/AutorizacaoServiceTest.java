package com.jesantiago.autenticadoroperacao.service;

import com.jesantiago.autenticadoroperacao.model.AutorizacaoModel;
import com.jesantiago.autenticadoroperacao.model.SituacaoAutorizacao;
import com.jesantiago.autenticadoroperacao.repository.AutorizacaoRepository;
import com.jesantiago.autenticadoroperacao.service.AutorizacaoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class AutorizacaoServiceTest {

    @TestConfiguration
    static class AutorizacaoServiceTestConfiguration{
        @Bean
        public AutorizacaoService autorizacaoService(){
            return new AutorizacaoService();
        }
    }

    @Autowired
    AutorizacaoService autorizacaoService;

    @MockBean
    AutorizacaoRepository autorizacaoRepository;

    @Test
    public void autorizacaoServiceTestVerificaSituacaoExistente(){
        String idAutorizacao = "7bb3afe7-cb63-4429-8837-de67cf6f8673";
        String situacao = autorizacaoService.verificaSituacao(idAutorizacao);

        Assertions.assertEquals("PENDENTE", situacao);
    }

    @Test
    public void autorizacaoServiceTestVerificaSituacaoNaoExistente(){
        String idAutorizacao = "1234567890";
        String situacao = autorizacaoService.verificaSituacao(idAutorizacao);

        Assertions.assertEquals(null, situacao);
    }

    @BeforeEach
    public void setup(){
        SituacaoAutorizacao situacaoAutorizacao = SituacaoAutorizacao.PENDENTE;
        LocalDate dataSolicitacao = LocalDate.parse("2020-12-18");

        AutorizacaoModel autorizacaoModel = new AutorizacaoModel(
                1l,
                "7bb3afe7-cb63-4429-8837-de67cf6f8673",
                "Terminal 1",
                dataSolicitacao,
                "11209235730",
                "123456",
                "Solic. p/ saque no valor de R$100,00",
                situacaoAutorizacao);

        Mockito.when(autorizacaoRepository.findByIdAutorizacao(autorizacaoModel.getIdAutorizacao())).thenReturn(List.of(autorizacaoModel));

    }

}
