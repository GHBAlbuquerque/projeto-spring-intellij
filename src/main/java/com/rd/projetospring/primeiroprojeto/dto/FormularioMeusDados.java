package com.rd.projetospring.primeiroprojeto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormularioMeusDados {

    private Usuario usuario;
    //private LoginUsuario loginUsuario;
    private BigInteger idPlano;
    private Contato contato;
    private List<Uf> ufs;
    private List<Genero> genero;
    private List<Planos> planos;
}
