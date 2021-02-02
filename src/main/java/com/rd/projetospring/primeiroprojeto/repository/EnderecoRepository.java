package com.rd.projetospring.primeiroprojeto.repository;

import com.rd.projetospring.primeiroprojeto.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, BigInteger> {
}
