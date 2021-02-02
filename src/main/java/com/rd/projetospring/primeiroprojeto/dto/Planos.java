package com.rd.projetospring.primeiroprojeto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Planos {
    private BigInteger idPlano;
    private String nmPlano;
    private String dsPlano;
    private String idServicoPlano;
    private Double vlPlano;
    private List<ServicoPlano> servicos;

}
