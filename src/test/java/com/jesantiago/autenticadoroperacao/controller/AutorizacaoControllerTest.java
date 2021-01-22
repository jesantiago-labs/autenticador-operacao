package com.jesantiago.autenticadoroperacao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jesantiago.autenticadoroperacao.model.AutorizacaoModel;
import com.jesantiago.autenticadoroperacao.model.SituacaoAutorizacao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc
public class AutorizacaoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //https://memorynotfound.com/unit-test-spring-mvc-rest-service-junit-mockito/

    @Test
    public void autorizacaoTestGetAutorizacaoServico() throws Exception {
        String idAutorizacao = "7bb3afe7-cb63-4429-8837-de67cf6f8673";

        mockMvc.perform(get("/autorizacoes/{idAutorizacao}", idAutorizacao))
                .andExpect(status().isOk());
    }

    @Test
    public void autorizacaoTestPostAutorizacaoServico() throws Exception {
        SituacaoAutorizacao situacaoAutorizacao = SituacaoAutorizacao.PENDENTE;
        LocalDate dataSolicitacao = LocalDate.parse("2020-12-18");

        AutorizacaoModel autorizacaoModel = new AutorizacaoModel(
                1,
                "7bb3afe7-cb63-4429-8837-de67cf6f8673",
                "Terminal 1",
                dataSolicitacao,
                "11209235730",
                "123456",
                "Solic. p/ saque no valor de R$100,00",
                situacaoAutorizacao);

        mockMvc.perform(post("/autorizacoes/")
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(autorizacaoModel)))
                .andExpect(status().isOk());
    }

}
