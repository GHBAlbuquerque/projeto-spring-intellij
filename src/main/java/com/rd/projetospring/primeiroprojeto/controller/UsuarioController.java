package com.rd.projetospring.primeiroprojeto.controller;

import com.rd.projetospring.primeiroprojeto.dto.Usuario;
import com.rd.projetospring.primeiroprojeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/usuario")
    public ResponseEntity getUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getUsuarios());
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity getUsuarioById(@PathVariable("id") BigInteger id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getUsuarioById(id));
    }

    @PostMapping("/usuario")
    public ResponseEntity cadastrar(@RequestBody Usuario usuario) {
//        if (usuario.getNome() == null ) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Atributo nome é obrigatório!");
//        }

        String retorno = service.inserirUsuario(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);

    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity alterar(@RequestBody Usuario usuario, @PathVariable("id") BigInteger id) {

        String retorno = service.alterarUsuario(usuario, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity excluir(@PathVariable("id") BigInteger id) {
        String retorno = service.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

}
