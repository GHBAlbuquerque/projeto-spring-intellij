package com.rd.projetospring.primeiroprojeto.repository;

import com.rd.projetospring.primeiroprojeto.entity.ContatoEntity;
import com.rd.projetospring.primeiroprojeto.entity.TipoContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface TipoContatoRepository extends JpaRepository<TipoContatoEntity, BigInteger> {
}
