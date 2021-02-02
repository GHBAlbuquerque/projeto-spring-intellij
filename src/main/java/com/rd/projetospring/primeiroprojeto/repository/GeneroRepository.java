package com.rd.projetospring.primeiroprojeto.repository;

import com.rd.projetospring.primeiroprojeto.entity.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface GeneroRepository extends JpaRepository<GeneroEntity, BigInteger> {


}
