package com.rd.projetospring.primeiroprojeto.dto;

import com.rd.projetospring.primeiroprojeto.entity.TipoContatoEntity;
import com.rd.projetospring.primeiroprojeto.entity.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contato {

    private BigInteger idContato;
    private Usuario usuario;
    private BigInteger idLoja;
    private TipoContato idTipoContato;
    private String nrDdi;
    private String nrDdd;
    private String nrRamal;
    private String dsContato;

}
