package com.rd.projetospring.primeiroprojeto.controller;

import com.rd.projetospring.primeiroprojeto.dto.ServicoPlano;
import com.rd.projetospring.primeiroprojeto.service.ServicoPlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigInteger;

@RestController
public class ServPlanoController {

    @Autowired
    private ServicoPlanoService service;

    @GetMapping("/servico-plano")
    public ResponseEntity verServPlanos() {
        return ResponseEntity.ok(service.getServicosPlano());
    }

    @GetMapping("/servico-plano/{id}")
    public ResponseEntity verServPlano(@PathVariable("id") BigInteger id) {
        return ResponseEntity.ok(service.getServicoPlano(id));

    }

    @PostMapping("/servico-plano")
    public ResponseEntity<String> inserirPlano(@RequestBody ServicoPlano servicoPlano) {

        String retorno = service.cadastrarServPlano(servicoPlano);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }

    @PutMapping("/servico-plano/{id}")
    public ResponseEntity alterarPlano(@RequestBody ServicoPlano servicoPlano, @PathVariable("id") BigInteger id) {

        String retorno = service.alterarServPlano(servicoPlano, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

    @DeleteMapping("/servico-plano/{id}")
    public ResponseEntity deletarCidade(@PathVariable("id") BigInteger id) {
        String retorno = service.deletarServPlano(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }
}
