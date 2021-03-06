package com.rd.projetospring.primeiroprojeto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private BigInteger id;
    private BigInteger idTipoUsuario;
    private String nome;
    private String cpf;
    private Date dtNascimento;
    private List<Endereco> enderecos;
}
