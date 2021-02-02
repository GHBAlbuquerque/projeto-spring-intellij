package com.rd.projetospring.primeiroprojeto.controller;

import com.rd.projetospring.primeiroprojeto.dto.Planos;
import com.rd.projetospring.primeiroprojeto.service.PlanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigInteger;

@RestController
public class PlanosController {

    @Autowired
    private PlanosService service;

    @GetMapping("/plano")
    public ResponseEntity verPlanos() {

        return ResponseEntity.ok(service.getPlanos());
    }

    @GetMapping("/plano/{id}")
    public ResponseEntity verPlano(@PathVariable("id") BigInteger id) {
        return ResponseEntity.ok(service.getPlanoDTO(id));

    }

    @PostMapping("/plano")
    public ResponseEntity<String> inserirPlano(@RequestBody Planos plano) {

        String retorno = service.cadastrarPlano(plano);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }

    @PutMapping("/plano/{id}")
    public ResponseEntity alterarPlano(@RequestBody Planos plano, @PathVariable("id") BigInteger id) {

        String retorno = service.alterarPlano(plano, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

    @DeleteMapping("/plano/{id}")
    public ResponseEntity deletarCidade(@PathVariable("id") BigInteger id) {
        String retorno = service.deletarPlano(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }
}
