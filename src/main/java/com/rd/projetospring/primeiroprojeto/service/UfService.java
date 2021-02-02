package com.rd.projetospring.primeiroprojeto.service;

import com.rd.projetospring.primeiroprojeto.dto.Uf;
import com.rd.projetospring.primeiroprojeto.entity.UfEntity;
import com.rd.projetospring.primeiroprojeto.repository.UfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UfService {

    @Autowired
    private UfRepository repository;

    public List<UfEntity> getUfs() {
        List<UfEntity> ufsEntities = repository.findAll();
        return ufsEntities;
    }

    public List<Uf> getUfsDTO() {
        List<UfEntity> ufsEntities = getUfs();

        //Listas para DTOs
        List<Uf> ufs = new ArrayList<>();

        //DTO conversões
        for(UfEntity ufEntity: ufsEntities) {
            Uf uf = new Uf();
            uf.setIdUf(ufEntity.getIdUf());
            uf.setDsUf(ufEntity.getDsUf());

            ufs.add(uf);
        }

        return ufs;
    }


}
