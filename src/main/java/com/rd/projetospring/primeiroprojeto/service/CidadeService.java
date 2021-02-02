package com.rd.projetospring.primeiroprojeto.service;

import com.rd.projetospring.primeiroprojeto.dto.Cidade;
import com.rd.projetospring.primeiroprojeto.entity.CidadeEntity;
import com.rd.projetospring.primeiroprojeto.entity.UfEntity;
import com.rd.projetospring.primeiroprojeto.repository.CidadeRepository;
import com.rd.projetospring.primeiroprojeto.repository.UfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired private CidadeRepository repository;
    @Autowired private UfRepository ufRepository;

    public Cidade verCidade(BigInteger id) {

        Optional<CidadeEntity> optional = repository.findById(id);
        CidadeEntity cidadeEntity = optional.get();


        Cidade cidade = new Cidade();
        cidade.setIdCidade(cidadeEntity.getIdCidade());
        cidade.setIdUf(cidadeEntity.getUf().getIdUf());
        cidade.setCdCidadeIbge(cidadeEntity.getCdCidadeIbge());
        cidade.setDsCidade(cidadeEntity.getDsCidade());

        return cidade;
    }

    public List verCidades(BigInteger id) {
        List<CidadeEntity> cidades = repository.findAll();
        return cidades;
    }

    @Transactional
    public String cadastrar(Cidade cidade) {
        CidadeEntity cidadeEntity = new CidadeEntity();

        UfEntity ufEntity = ufRepository.findById(cidadeEntity.getUf().getIdUf()).get();

        cidadeEntity.setUf(ufEntity);
        cidadeEntity.setCdCidadeIbge(cidade.getCdCidadeIbge());
        cidadeEntity.setDsCidade(cidade.getDsCidade());

        repository.save(cidadeEntity);

        return "Inserção feita com sucesso!";
    }

    @Transactional
    public String alterarCidade(Cidade cidade, BigInteger id) {
        Optional<CidadeEntity> optional = repository.findById(id);
        CidadeEntity cidadeEntity = optional.get();
        UfEntity ufEntity = ufRepository.findById(cidadeEntity.getUf().getIdUf()).get();

        cidadeEntity.setUf(ufEntity);
        cidadeEntity.setCdCidadeIbge(cidade.getCdCidadeIbge());
        cidadeEntity.setDsCidade(cidade.getDsCidade());

        repository.save(cidadeEntity);

        return "Alteração feita com sucesso!";
    }

    public String deletarCidade(BigInteger id) {
//        Optional<UsuarioEntity> optional = repository.findById(id);
//        UsuarioEntity usuarioEntity = optional.get();
//        repository.delete(usuarioEntity);

        repository.deleteById(id);

        return "Remoção feita com sucesso!";
    }


}
