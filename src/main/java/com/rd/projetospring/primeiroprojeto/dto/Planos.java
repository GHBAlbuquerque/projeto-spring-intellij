package com.rd.projetospring.primeiroprojeto.dto;

import com.rd.projetospring.primeiroprojeto.entity.ServPlanoEntity;
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
    private String nomePlano;
    private String dsPlano;
    private String idServicoPlano;
    private Double vlPlano;
    private List<ServPlano> servicos;

}
