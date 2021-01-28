package com.rd.projetospring.primeiroprojeto.repository;

import com.rd.projetospring.primeiroprojeto.entity.CidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CidadeRepository extends JpaRepository<CidadeEntity, BigInteger> {
}
