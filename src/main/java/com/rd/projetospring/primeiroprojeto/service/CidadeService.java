package com.rd.projetospring.primeiroprojeto.service;

import com.rd.projetospring.primeiroprojeto.dto.Cidade;
import com.rd.projetospring.primeiroprojeto.entity.CidadeEntity;
import com.rd.projetospring.primeiroprojeto.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    public Cidade verCidade(BigInteger id) {

        Optional<CidadeEntity> optional = repository.findById(id);
        CidadeEntity cidadeEntity = optional.get();

        Cidade cidade = new Cidade();
        cidade.setIdCidade(cidadeEntity.getIdCidade());
        cidade.setIdUF(cidadeEntity.getIdUf());
        cidade.setCdCidadeIbge(cidadeEntity.getCdCidadeIbge());
        cidade.setDsCidade(cidadeEntity.getDsCidade());

        return cidade;
    }

    public List verCidades(BigInteger id) {
        List<CidadeEntity> cidades = repository.findAll();
        return cidades;
    }


}
