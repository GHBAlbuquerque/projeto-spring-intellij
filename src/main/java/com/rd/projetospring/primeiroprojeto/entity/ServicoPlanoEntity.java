package com.rd.projetospring.primeiroprojeto.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "TB_SERVICO_PLANO")
@Data
public class ServicoPlanoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_SERVICO_PLANO")
    private BigInteger idServicoPlano;

    @Column(name="DS_SERVICO")
    private String dsServico;
}
