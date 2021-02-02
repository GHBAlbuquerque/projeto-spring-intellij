package com.rd.projetospring.primeiroprojeto.service;

import com.rd.projetospring.primeiroprojeto.dto.Genero;
import com.rd.projetospring.primeiroprojeto.dto.Uf;
import com.rd.projetospring.primeiroprojeto.entity.GeneroEntity;
import com.rd.projetospring.primeiroprojeto.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;


    public List<GeneroEntity> getGeneros() {
        List<GeneroEntity> generoEntities = generoRepository.findAll();
        return generoEntities;
    }

    public List<Genero> getGenerosDTO() {
        List<GeneroEntity> generoEntities = getGeneros();
        List<Genero> generos = new ArrayList<>();

        for(GeneroEntity generoEntity: generoEntities) {
            Genero genero = new Genero();
            genero.setIdGenero(generoEntity.getIdGenero());
            genero.setDsGenero(generoEntity.getDsGenero());

            generos.add(genero);
        }

        return generos;
    }
}
