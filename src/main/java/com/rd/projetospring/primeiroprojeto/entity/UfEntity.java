package com.rd.projetospring.primeiroprojeto.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "TB_UF")
@Data
public class UfEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID_UF")
    private BigInteger idUf;

    @Column(name = "DS_UF")
    private String dsUf;

    //relacionamento Bi-direcional
    @OneToMany(mappedBy = "uf")
    private List<CidadeEntity> cidades;

}
