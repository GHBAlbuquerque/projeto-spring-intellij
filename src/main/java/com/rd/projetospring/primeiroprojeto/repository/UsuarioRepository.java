package com.rd.projetospring.primeiroprojeto.repository;

import com.rd.projetospring.primeiroprojeto.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, BigInteger> {
}
