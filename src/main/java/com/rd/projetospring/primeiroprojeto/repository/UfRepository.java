package com.rd.projetospring.primeiroprojeto.repository;

import com.rd.projetospring.primeiroprojeto.entity.UfEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UfRepository extends JpaRepository<UfEntity, BigInteger> {
}
