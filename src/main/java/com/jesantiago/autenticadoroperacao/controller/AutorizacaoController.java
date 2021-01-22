package com.jesantiago.autenticadoroperacao.controller;

import com.jesantiago.autenticadoroperacao.model.AutorizacaoModel;
import com.jesantiago.autenticadoroperacao.repository.AutorizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/autorizacoes")
public class AutorizacaoController {

    @Autowired
    AutorizacaoRepository autorizacaoRepository;

    @GetMapping("/{idAutorizacao}")
    public ResponseEntity<AutorizacaoModel> getIdAutorizacao(@PathVariable String idAutorizacao) throws Exception{

        List<AutorizacaoModel> autorizacaoModel = autorizacaoRepository.findByIdAutorizacao(idAutorizacao);

        if (!autorizacaoModel.isEmpty()) {
            return new ResponseEntity<>(autorizacaoModel.get(0), HttpStatus.OK);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @PostMapping
    public ResponseEntity<AutorizacaoModel> postAutorizacaoModel(@RequestBody AutorizacaoModel autorizacaoModel){
        AutorizacaoModel _autorizacaoModel = autorizacaoRepository
                .save(new AutorizacaoModel(
                        0,
                        autorizacaoModel.getIdAutorizacao(),
                        autorizacaoModel.getNomeServico(),
                        LocalDate.now(),
                        autorizacaoModel.getIdCliente(),
                        autorizacaoModel.getToken(),
                        autorizacaoModel.getMensagemAutorizacao(),
                        autorizacaoModel.getSituacaoAutorizacao()
                ));
        return new ResponseEntity<>(_autorizacaoModel, HttpStatus.CREATED);
    }

}
