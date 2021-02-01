package com.rd.projetospring.primeiroprojeto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@NoArgsConstructor //cria o construtor vazio
@AllArgsConstructor //cria o construtor com todos os atributos

@Entity
@Table(name = "TB_TIPO_CONTATO")
@Data //getters e setters
public class TipoContatoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_CONTATO")
    private BigInteger idTipoContato;

    @Column(name = "DS_TIPO_CONTATO")
    private String dsTipoContato;
}
