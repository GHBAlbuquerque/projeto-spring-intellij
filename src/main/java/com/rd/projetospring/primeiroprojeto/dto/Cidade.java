package com.rd.projetospring.primeiroprojeto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {
    private BigInteger idCidade;
    private BigInteger idUF;
    private BigInteger cdCidadeIbge;
    private String 	dsCidade;
}
