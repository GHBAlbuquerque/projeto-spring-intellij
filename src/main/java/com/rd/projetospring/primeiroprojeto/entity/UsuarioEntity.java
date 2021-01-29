package com.rd.projetospring.primeiroprojeto.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
@Data
public class UsuarioEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_USUARIO")
    private BigInteger idUsuario;

    @Column(name = "ID_GENERO")
    private BigInteger genero;

    @Column(name="ID_ESP_MED")
    private BigInteger idEspMed;

    @Column(name="ID_UF_CRM")
    private BigInteger idUfCrm;

    @Column(name="ID_TIPO_USUARIO")
    private BigInteger idTipoUsuario;

    @Column(name="NM_NOME")
    private String nome;

    @Column(name="DT_NASCIMENTO")
    private Date dtNascimento;

    @Column(name="NR_CPF")
    private String cpf;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TB_USUARIO_ENDERECO",
            joinColumns = @JoinColumn(name = "ID_USUARIO"),
            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO")
    )
    private List<EnderecoEntity> enderecos;
}
