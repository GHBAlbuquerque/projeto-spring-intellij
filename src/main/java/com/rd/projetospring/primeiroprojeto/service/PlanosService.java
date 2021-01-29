package com.rd.projetospring.primeiroprojeto.service;

import com.rd.projetospring.primeiroprojeto.dto.Planos;
import com.rd.projetospring.primeiroprojeto.dto.ServPlano;
import com.rd.projetospring.primeiroprojeto.entity.PlanosEntity;
import com.rd.projetospring.primeiroprojeto.entity.ServPlanoEntity;
import com.rd.projetospring.primeiroprojeto.repository.PlanosRepository;
import com.rd.projetospring.primeiroprojeto.repository.ServPlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanosService {

    @Autowired
    private PlanosRepository repository;
    @Autowired
    private ServPlanoRepository servRepository;

    public Planos verPlano(BigInteger id) {

        Optional<PlanosEntity> optional = repository.findById(id);
        PlanosEntity planoEntity = optional.get();

        Planos plano = new Planos();
        plano.setIdPlano(planoEntity.getIdPlano());
        plano.setNomePlano(planoEntity.getNomePlano());
        plano.setDsPlano(planoEntity.getDsPlano());
        plano.setVlPlano(planoEntity.getVlPlano());

        return plano;
    }

    public List verPlanos(BigInteger id) {
        List<PlanosEntity> planos = repository.findAll();
        return planos;
    }

    @Transactional
    public String cadastrarPlano(Planos plano) {
        PlanosEntity planoEntity = new PlanosEntity();

        planoEntity.setNomePlano(plano.getNomePlano());
        planoEntity.setDsPlano(plano.getDsPlano());
        planoEntity.setVlPlano(plano.getVlPlano());

        //TODO
        List<ServPlanoEntity> listaServPlano = new ArrayList<>();
        for(ServPlano servico : plano.getServicos()) {
//            ServPlanoEntity servPlanoEntity = new ServPlanoEntity();
//            servPlanoEntity.setIdServicoPlano(servico.getIdServicoPlano());
//            servPlanoEntity.setDsServico(servico.getDsServico());

            BigInteger idServicoPlano = servico.getIdServicoPlano();
            Optional<ServPlanoEntity> optional = servRepository.findById(idServicoPlano);
            ServPlanoEntity servPlanoEntity = optional.get();
            listaServPlano.add(servPlanoEntity);
        }

        planoEntity.setServicos(listaServPlano);

        repository.save(planoEntity);

        return "Inserção feita com sucesso!";
    }

    @Transactional
    public String alterarPlano(Planos plano, BigInteger id) {
        Optional<PlanosEntity> optional = repository.findById(id);
        PlanosEntity planoEntity = optional.get();

        planoEntity.setNomePlano(plano.getNomePlano());
        planoEntity.setDsPlano(plano.getDsPlano());
        planoEntity.setVlPlano(plano.getVlPlano());

        repository.save(planoEntity);

        return "Alteração feita com sucesso!";
    }

    public String deletarPlano(BigInteger id) {
//        Optional<UsuarioEntity> optional = repository.findById(id);
//        UsuarioEntity usuarioEntity = optional.get();
//        repository.delete(usuarioEntity);

        repository.deleteById(id);

        return "Remoção feita com sucesso!";
    }

}
