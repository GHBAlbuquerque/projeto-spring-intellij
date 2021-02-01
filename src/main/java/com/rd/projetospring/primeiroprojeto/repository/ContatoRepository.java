package com.rd.projetospring.primeiroprojeto.repository;

import com.rd.projetospring.primeiroprojeto.entity.ContatoEntity;
import com.rd.projetospring.primeiroprojeto.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface ContatoRepository extends JpaRepository<ContatoEntity, BigInteger> {

    List<ContatoEntity> findByUsuario(UsuarioEntity usuarioEntity);

    List<ContatoEntity> findByIdLoja(BigInteger idLoja);
}
