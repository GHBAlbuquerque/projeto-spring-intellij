package com.rd.projetospring.primeiroprojeto.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "TB_CIDADE")
@Data
public class CidadeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name="ID_CIDADE")
    private BigInteger idCidade;

    @Column(name="ID_UF")
    private BigInteger idUf;

    @Column(name="CD_CIDADE_IBGE")
    private BigInteger cdCidadeIbge;

    @Column(name="DS_CIDADE")
    private String dsCidade;

}
