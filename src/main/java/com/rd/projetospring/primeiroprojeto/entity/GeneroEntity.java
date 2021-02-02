package com.rd.projetospring.primeiroprojeto.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="TB_GENERO")
@Data
public class GeneroEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID_GENERO")
    private BigInteger idGenero;

    @Column(name = "DS_GENERO")
    private String dsGenero;
}
