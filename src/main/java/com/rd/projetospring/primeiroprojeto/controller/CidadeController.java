package com.rd.projetospring.primeiroprojeto.controller;

import com.rd.projetospring.primeiroprojeto.dto.Cidade;
import com.rd.projetospring.primeiroprojeto.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigInteger;

@RestController
public class CidadeController {

    @Autowired
    private CidadeService service;

    @GetMapping("/cidade")
    public ResponseEntity verCidades(@PathParam("id") BigInteger id) {
        return ResponseEntity.ok(service.verCidades(id));
    }

    @GetMapping("/cidade/{id}")
    public ResponseEntity verCidade(@PathVariable("id") BigInteger id) {
        return ResponseEntity.ok(service.verCidade(id));

    }


    @PostMapping("/cidade")
    public ResponseEntity<String> inserirCidade(@RequestBody Cidade cidade) {

        String retorno = service.cadastrar(cidade);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }


    @PutMapping("/cidade/{id}")
    public ResponseEntity alterarCidade(@RequestBody Cidade cidade, @PathVariable("id") BigInteger id) {

        String retorno = service.alterarCidade(cidade, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

    @DeleteMapping("/cidade/{id}")
    public ResponseEntity deletarCidade(@PathVariable("id") BigInteger id) {
        String retorno = service.deletarCidade(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

}
