package com.rd.projetospring.primeiroprojeto.dto;

import com.rd.projetospring.primeiroprojeto.entity.CidadeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Uf {

    private BigInteger idUf;
    private String dsUf;
    private List<Cidade> cidades;

}
