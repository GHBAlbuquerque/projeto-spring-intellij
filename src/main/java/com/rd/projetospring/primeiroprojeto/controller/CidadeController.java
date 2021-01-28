package com.rd.projetospring.primeiroprojeto.controller;

import com.rd.projetospring.primeiroprojeto.dto.Cidade;
import com.rd.projetospring.primeiroprojeto.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String inserirCidade(@RequestBody Cidade cidade) {

        return "Cadastro de cidade feito com sucesso";
    }


    @PutMapping("/cidade/{id}")
    public String alterarCidade(@RequestBody Cidade cidade, @PathVariable("id") BigInteger id) {

        return "Alteração de cidade feita com sucesso";
    }

    @DeleteMapping("/cidade/{id}")
    public String deletarCidade(@PathVariable("id") BigInteger id) {

        return "Exclusão de cidade feita com sucesso";
    }

}
