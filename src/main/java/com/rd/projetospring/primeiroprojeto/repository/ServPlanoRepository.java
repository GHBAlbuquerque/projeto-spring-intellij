package com.rd.projetospring.primeiroprojeto.repository;

import com.rd.projetospring.primeiroprojeto.entity.PlanosEntity;
import com.rd.projetospring.primeiroprojeto.entity.ServPlanoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ServPlanoRepository extends JpaRepository<ServPlanoEntity, BigInteger> {
}