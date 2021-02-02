package com.rd.projetospring.primeiroprojeto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genero {

    private BigInteger idGenero;
    private String dsGenero;
}
