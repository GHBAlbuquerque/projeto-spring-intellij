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
@Table(name = "TB_CONTATO")
@Data //getters e setters
public class ContatoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTATO")
    private BigInteger idContato;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private UsuarioEntity usuario;

    @Column(name = "ID_LOJA")
    private BigInteger idLoja;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_CONTATO")
    private TipoContatoEntity idTipoContato;

    @Column(name = "NR_DDI")
    private String nrDdi;

    @Column(name = "NR_DDD")
    private String nrDdd;

    @Column(name = "NR_RAMAL")
    private String nrRamal;

    @Column(name = "DS_CONTATO")
    private String dsContato;

}
