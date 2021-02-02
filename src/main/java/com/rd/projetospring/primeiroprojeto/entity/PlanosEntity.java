package com.rd.projetospring.primeiroprojeto.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name ="TB_PLANOS")
@Data
public class PlanosEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_PLANO")
    private BigInteger idPlano;

    @Column(name="NM_PLANO")
    private String nmPlano;

    @Column(name="DS_PLANO")
    private String dsPlano;

    @Column(name="ID_SERVICO_PLANO")
    private String idServicoPlano;

    @Column(name="VL_PLANO")
    private Double vlPlano;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TB_PLANOS_SERVPLANOS",
            joinColumns = @JoinColumn(name = "ID_PLANO"),
            inverseJoinColumns = @JoinColumn(name = "ID_SERVICO_PLANO")
    )
    private List<ServicoPlanoEntity> servicos;


}
