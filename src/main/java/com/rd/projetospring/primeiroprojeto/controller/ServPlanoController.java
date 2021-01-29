package com.rd.projetospring.primeiroprojeto.controller;

import com.rd.projetospring.primeiroprojeto.dto.Planos;
import com.rd.projetospring.primeiroprojeto.dto.ServPlano;
import com.rd.projetospring.primeiroprojeto.service.ServPlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigInteger;

@RestController
public class ServPlanoController {

    @Autowired
    private ServPlanoService service;

    @GetMapping("/servico-plano")
    public ResponseEntity verServPlanos(@PathParam("id") BigInteger id) {
        return ResponseEntity.ok(service.verServsPlano(id));
    }

    @GetMapping("/servico-plano/{id}")
    public ResponseEntity verServPlano(@PathVariable("id") BigInteger id) {
        return ResponseEntity.ok(service.verServPlano(id));

    }

    @PostMapping("/servico-plano")
    public ResponseEntity<String> inserirPlano(@RequestBody ServPlano servPlano) {

        String retorno = service.cadastrarServPlano(servPlano);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }

    @PutMapping("/servico-plano/{id}")
    public ResponseEntity alterarPlano(@RequestBody ServPlano servPlano, @PathVariable("id") BigInteger id) {

        String retorno = service.alterarServPlano(servPlano, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

    @DeleteMapping("/servico-plano/{id}")
    public ResponseEntity deletarCidade(@PathVariable("id") BigInteger id) {
        String retorno = service.deletarServPlano(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }
}
