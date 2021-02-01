package com.rd.projetospring.primeiroprojeto.controller;

import com.rd.projetospring.primeiroprojeto.dto.Contato;
import com.rd.projetospring.primeiroprojeto.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
public class ContatoController {

    @Autowired
    private ContatoService service;

    @GetMapping("/contato")
    public ResponseEntity verContatos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.verContatos());
    }

    @GetMapping("/contato/{id}")
    public ResponseEntity verContato(@PathVariable("id") BigInteger id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.verContatoById(id));
    }

    @GetMapping("/contato/user/{idUsuario}")
    public ResponseEntity verContatoByUser(@PathVariable("idUsuario") BigInteger idUsuario) {
        return ResponseEntity.status(HttpStatus.OK).body(service.verContatosPorUsuario(idUsuario));
    }

    @GetMapping("/contato/loja/{idLoja}")
    public ResponseEntity verContatoByLoja(@PathVariable("idLoja") BigInteger idLoja) {
        return ResponseEntity.status(HttpStatus.OK).body(service.verContatosPorLoja(idLoja));
    }

    @PostMapping("/contato") //CADASTRO
    public ResponseEntity cadastrarContato(@RequestBody Contato contato) {
        return ResponseEntity.status(HttpStatus.OK).body(service.cadastrarContato(contato)); //método da minha service
    }

    @PutMapping("/contato/{id}") //ALTERAÇÕES
    public ResponseEntity alterarContato(@RequestBody Contato contato, @PathVariable("id") BigInteger id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.alterarContato(contato, id)); //método da minha service
    }

    @DeleteMapping("/contato/{id}") //DELETAR
    public ResponseEntity deletarContato(@PathVariable("id") BigInteger id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deletarContato(id)); //método da minha service
    }

}
